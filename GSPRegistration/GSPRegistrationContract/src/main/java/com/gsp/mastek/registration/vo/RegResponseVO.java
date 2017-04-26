package com.gsp.mastek.registration.vo;

import com.gsp.mastek.common.vo.BaseVO;

public class RegResponseVO<T> extends BaseVO{
	private T payload;

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "RegRequestVO [payload=" + payload + "]";
	}
}
