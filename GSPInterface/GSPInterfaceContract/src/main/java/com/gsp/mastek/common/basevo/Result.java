package com.gsp.mastek.common.basevo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gsp.mastek.common.vo.OutwardDTO;

public class Result<T> implements OutwardDTO{
	public String status_cd;
	
    public T data;
    
    public Error error;
    
    public String sek;
    
    public String sign;
    
    public String rek;
    
    public String hmac;

	public String getStatus_cd() {
		return status_cd;
	}

	public void setStatus_cd(String status_cd) {
		this.status_cd = status_cd;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public String getSek() {
		return sek;
	}

	public void setSek(String sek) {
		this.sek = sek;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getRek() {
		return rek;
	}

	public void setRek(String rek) {
		this.rek = rek;
	}

	public String getHmac() {
		return hmac;
	}

	public void setHmac(String hmac) {
		this.hmac = hmac;
	}

	@Override
	public String toString() {
		return "Result [status_cd=" + status_cd + ", data=" + data + ", error=" + error + ", sek=" + sek + ", sign="
				+ sign + ", rek=" + rek + ", hmac=" + hmac + "]";
	}
	
}
