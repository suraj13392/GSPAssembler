package com.gsp.mastek.common.basevo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsp.mastek.common.vo.AdapterBaseDTO;

public class Error implements AdapterBaseDTO {

	@JsonProperty("error_cd")
	private String errorCode;
    
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [errorCode=" + errorCode + ", message=" + message + "]";
	}
	
}
