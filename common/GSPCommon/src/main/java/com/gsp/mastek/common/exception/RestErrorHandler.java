package com.gsp.mastek.common.exception;

import java.util.List;
import java.util.Locale;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.gsp.mastek.common.CommonConstant;
import com.gsp.mastek.common.vo.FieldErrorVO;
import com.gsp.mastek.common.vo.ValidationErrorDTO;

@ControllerAdvice
public class RestErrorHandler {

	private MessageSource messageSource;	

	@Autowired
	public RestErrorHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		//logger.warn("ConstraintViolationException: " + fieldErrors.toString());
		return processFieldErrors(fieldErrors);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleConstraintViolationException(ConstraintViolationException ex) {
		List<FieldErrorVO> errors = FieldErrorVO.getErrors(ex.getConstraintViolations());
		//logger.warn("ConstraintViolationException: " + errors.toString());
		return processFieldErrorVO(errors);
	}

	@ExceptionHandler(MultiErrorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO handleMultiErrorExceptionException(MultiErrorException ex) {
		List<FieldErrorVO> errors = ex.getErrors();
		//logger.warn("MultiErrorException: " + errors.toString());
		return processFieldErrorVO(errors);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidationErrorDTO processAllExceptions(Throwable ex) {
		
		if(ex instanceof Exception){
			ex.printStackTrace();
			//logger.error("processAllExceptions ",(Exception) ex);
		}else{
			//logger.warn("Error :processAllExceptions " ,ExceptionUtils.getStackTrace(ex) );
		}
		
		ValidationErrorDTO dto = new ValidationErrorDTO();
		dto.setStatus(CommonConstant.FAILED);
		dto.addFieldError("Request", "Request can not be processed");
		return dto;
	}

	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorDTO dto = new ValidationErrorDTO();
		dto.setStatus(CommonConstant.FAILED);

		for (FieldError fieldError : fieldErrors) {

			String localizedErrorMessage = fieldError.getDefaultMessage();

			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return dto;
	}

	private ValidationErrorDTO processFieldErrorVO(List<FieldErrorVO> fieldErrorVOs) {
		ValidationErrorDTO dto = new ValidationErrorDTO();
		dto.setStatus(CommonConstant.FAILED);

		//logger.info("processFieldErrorVO:fieldErrorVOs ==> " + fieldErrorVOs);

		for (FieldErrorVO fieldError : fieldErrorVOs) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError.getCode(), fieldError.getArgs());
			if (localizedErrorMessage == null) {
				localizedErrorMessage = fieldError.getMessage();
			}
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return dto;
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
