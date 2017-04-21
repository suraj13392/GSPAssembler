package com.gsp.mastek.rest.client.vo;

import com.gsp.mastek.common.vo.InwardDTO;

public class OTPRequestVO extends HeaderData implements InwardDTO {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
