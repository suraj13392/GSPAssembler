package com.gsp.mastek.master.service;

import java.util.List;

import com.gsp.mastek.master.vo.RolesVO;

public interface RoleService {

	public void save(RolesVO rolesVO);

	public List<RolesVO> fetchAllRoles();
}
