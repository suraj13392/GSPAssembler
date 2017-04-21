package com.gsp.mastek.rest.client.common;

import com.gsp.mastek.common.basevo.Result;
import com.gsp.mastek.common.exception.DataMappingException;
import com.gsp.mastek.common.exception.MultiErrorException;
import com.gsp.mastek.common.mapper.DataMapper;
import com.gsp.mastek.common.vo.InwardDTO;
import com.gsp.mastek.common.vo.OutwardDTO;
import com.gsp.mastek.rest.client.vo.GSTNAuthRequestVO;

import retrofit2.Response;

import com.gsp.mastek.common.basevo.Error;

public class BaseGSPDataMapper implements DataMapper {

	public Object mapRequestData(InwardDTO inwardDTO) throws DataMappingException {
		return inwardDTO;
	}

	public OutwardDTO mapResponseData(Object object) throws DataMappingException {
		Response<Result> response = (Response<Result>) (object);
		if (response == null) {
			throw MultiErrorException.getExceptionInstanceWithMessage("GSTN", "No Response from GSTN call");
		}

		// TODO : We can customize the response in other object in case of
		// success or error.As of now using the same.
		Result result = null;
		if (response.isSuccessful()) {// Status of Http Call

			result = response.body();
		} else {
			result = new Result<GSTNAuthRequestVO>();
			result.setStatus_cd("0");

			okhttp3.Response errResp = response.raw();
			Error error = new Error();
			String code = "" + errResp.code();
			error.setErrorCode(code);
			// String message = ResourceBundler.getStringResource(code);
			// error.setMessage(message);
			result.setError(error);
		}

		return result;
	}

}