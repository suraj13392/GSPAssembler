package com.gsp.mastek.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gsp.mastek.common.error.vo.ErrorDTO;
import com.gsp.mastek.common.error.vo.FieldErrorVO;
import com.gsp.mastek.common.exception.MultiErrorException;
import com.gsp.mastek.common.vo.BaseResponse;

@RestControllerAdvice
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object>{
	private static final Logger logger = Logger.getLogger(ResponseWrapperAdvice.class);
	private MessageSource messageSource;	

	@Autowired
	public ResponseWrapperAdvice(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		logger.info("beforeBodyWrite In");
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusSuccess();
		if(body != null){
		  baseResponse.setData(body);
	    }
		String requestStr= new String();
		try {
			InputStream requestStream = request.getBody();
			if(requestStream != null) {
			 requestStr = IOUtils.toString(requestStream);
			 Object requestBodyObj = getJSONObjectIfValidJSONString(requestStr);			
			 baseResponse.setRequest(requestBodyObj);
			}
		} catch (IOException e) {
			logger.error("Some error while writing request",e);
		}
		logger.info("beforeBodyWrite return");
		/*If someone send base response object in body then instead of returning newly created baseresponse object return body */
		return body instanceof BaseResponse ? body : baseResponse;
	}

	//If requested JSON is not valid then return requested string as it is
	private Object getJSONObjectIfValidJSONString(String requestStr) {
		 ObjectMapper mapper = new ObjectMapper();
		 Object json = null;
		 try {
			json = mapper.readValue(requestStr, Object.class);
			return json;
		} catch (IOException e) {
			logger.error("Not valid JSON ",e);
		} 
		return requestStr;
	}

	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}
	
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,HttpServletRequest request) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		logger.warn("ConstraintViolationException: " + fieldErrors.toString());
		return processFieldErrors(fieldErrors,request);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResponse handleConstraintViolationException(ConstraintViolationException ex,HttpServletRequest request) {
		List<FieldErrorVO> errors = FieldErrorVO.getErrors(ex.getConstraintViolations());
		logger.warn("ConstraintViolationException: " + errors.toString());
		return processFieldErrorVO(errors,request);
	}

	@ExceptionHandler(MultiErrorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResponse handleMultiErrorExceptionException(MultiErrorException ex,HttpServletRequest request) {
		List<FieldErrorVO> errors = ex.getErrors();
		logger.warn("MultiErrorException: " + errors.toString());
		return processFieldErrorVO(errors,request);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public BaseResponse processAllExceptions(Throwable ex,HttpServletRequest request) {
		
		if(ex instanceof Exception){
			ex.printStackTrace();
			logger.error("processAllExceptions ",(Exception) ex);
		}else{
			logger.warn("Error :processAllExceptions " ,(Exception) ex );
		}
		
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusError();
		ErrorDTO dto = new ErrorDTO("Request", "Request can not be processed");
		baseResponse.addError(dto);
		setRequestInErrorResponse(baseResponse,request);
		return baseResponse;
	}

	private BaseResponse processFieldErrors(List<FieldError> fieldErrors, HttpServletRequest request) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusError();
		for (FieldError fieldError : fieldErrors) {
			ErrorDTO dto = new ErrorDTO();
			String localizedErrorMessage = fieldError.getDefaultMessage();
			dto.setCode(fieldError.getField());
			dto.setMessage(localizedErrorMessage);
			baseResponse.addError(dto);
		}		
		setRequestInErrorResponse(baseResponse,request);
		return baseResponse;
	}

	private BaseResponse processFieldErrorVO(List<FieldErrorVO> fieldErrorVOs, HttpServletRequest request) {
		logger.info("processFieldErrorVO:fieldErrorVOs ==> " + fieldErrorVOs);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusError();
		for (FieldErrorVO fieldError : fieldErrorVOs) {
			ErrorDTO dto = new ErrorDTO();
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError.getKey(), fieldError.getArgs());
			if (localizedErrorMessage == null) {
				localizedErrorMessage = fieldError.getMessage();
			}
			dto.setCode(fieldError.getField());
			dto.setMessage(localizedErrorMessage);
			baseResponse.addError(dto);
		}		
		setRequestInErrorResponse(baseResponse,request);
		return baseResponse;
	}
	
	private void setRequestInErrorResponse(BaseResponse baseResponse ,HttpServletRequest request){
		String requestStr= new String();
		try {
			InputStream requestStream = request.getInputStream();
			if(requestStream != null) {
			 requestStr = IOUtils.toString(requestStream);
			 Object requestBodyObj = getJSONObjectIfValidJSONString(requestStr);
			 baseResponse.setRequest(requestBodyObj);
			}
			logger.info("requestStr   " + requestStr);
		} catch (IOException e) {
			logger.error("Some error while writing request",e);
		}
	}

	private String resolveLocalizedErrorMessage(String code, Object[] args) {
		if (code == null) {
			return null;
		}
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(code, args, currentLocale);
		return localizedErrorMessage;
	}
	

}
