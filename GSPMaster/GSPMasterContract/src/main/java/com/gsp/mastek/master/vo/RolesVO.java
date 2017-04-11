package com.gsp.mastek.master.vo;

import com.gsp.mastek.common.vo.BaseVO;


public class RolesVO extends BaseVO{

	
	private Long id;
	
	private String roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	
}
