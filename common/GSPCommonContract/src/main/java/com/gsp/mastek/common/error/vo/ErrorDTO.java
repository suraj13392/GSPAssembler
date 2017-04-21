package com.gsp.mastek.common.error.vo;

import com.gsp.mastek.common.vo.IBaseResponse;

public class ErrorDTO implements IBaseResponse{
	
	private String code;
	
	private String message;

	public ErrorDTO() {
		super();
	}

	public ErrorDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorDTO [code=" + code + ", message=" + message + "]";
	}
}
