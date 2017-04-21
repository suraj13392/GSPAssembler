package com.gsp.mastek.rest.client.vo;

import java.util.HashMap;
import java.util.Map;

public class HeaderData {
	
	private Map<String,String> headers;

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	public void putHeaderValues(String key , String value){
		if(headers == null){
			headers = new HashMap<String, String>();
			headers.put(key, value);
		}else{
			headers.put(key, value);
		}
	}
}
