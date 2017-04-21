package com.gsp.mastek.common.vo;

import java.util.ArrayList;
import java.util.List;

import com.gsp.mastek.common.enums.ResponseType;
import com.gsp.mastek.common.error.vo.ErrorDTO;

public class BaseResponse<T> implements IBaseResponse{
	
	private String status;
	
	private T data;
	
	private List<ErrorDTO> errors;	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<ErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDTO> errors) {
		this.errors = errors;
	}
	
	public void setStatusSuccess() {
		this.status = ResponseType.SUCCESS.toString();
	}
	
	public void setStatusError() {
		this.status = ResponseType.ERROR.toString();
	}
	
	public void addError(ErrorDTO error){
		if(errors == null){
			errors = new ArrayList<ErrorDTO>();
			errors.add(error);
		}else{
			errors.add(error);
		}
	}

	@Override
	public String toString() {
		return "BaseResponse [status=" + status + ", data=" + data + ", errors=" + errors + "]";
	}

}
