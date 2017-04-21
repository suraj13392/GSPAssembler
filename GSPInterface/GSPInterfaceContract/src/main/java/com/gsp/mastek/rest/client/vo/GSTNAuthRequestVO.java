package com.gsp.mastek.rest.client.vo;

import com.gsp.mastek.common.vo.InwardDTO;

public class GSTNAuthRequestVO implements InwardDTO {

	private String action;
	
	private String app_key;
	
	private String username;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "GSTNAuthRequestVO [action=" + action + ", app_key=" + app_key + ", username=" + username + "]";
	}
}
