package com.gsp.mastek.rest.client.vo;

import java.util.Map;

import com.gsp.mastek.common.vo.InwardDTO;

public class GSTNAuthReqHeaderWrapper<T> implements InwardDTO {

	private Map<String,String> headers;
	
	private T reqData;

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public T getReqData() {
		return reqData;
	}

	public void setReqData(T reqData) {
		this.reqData = reqData;
	}

	@Override
	public String toString() {
		return "GSTNAuthReqHeaderWrapper [headers=" + headers + ", reqData=" + reqData + "]";
	}
	
}
