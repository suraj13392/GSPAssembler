package com.gsp.mastek.master.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.mapper.RolesMapper;
import com.gsp.mastek.master.model.Roles;
import com.gsp.mastek.master.repository.RolesRepository;
import com.gsp.mastek.master.service.RoleService;
import com.gsp.mastek.master.vo.RolesVO;

@Service
@Loggable
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private RolesMapper rolesMapper ;
	
	public void save(RolesVO rolesVO){
		Roles roles = rolesMapper.rolesVOToRoles(rolesVO);
		rolesRepository.save(roles);
	}
  
	@Loggable(result = false)
	private Roles getRolesEntity(RolesVO rolesVO) {
		Roles entity = new Roles();
		entity.setRoleName(rolesVO.getRoleName());
		return entity;
	}
	@Loggable(result = false)
	public List<RolesVO> fetchAllRoles(){
		Iterable<Roles> rolesData = rolesRepository.findAll();
		List<RolesVO> rolesVOs = getListOfRolesVO(rolesData);
		return rolesVOs;
	}

	private List<RolesVO> getListOfRolesVO(Iterable<Roles> rolesData) {
		List<RolesVO> rolesVOs = new ArrayList<>();
		for(Roles o : rolesData){
			RolesVO vo = rolesMapper.rolesToRolesVO(o);
			rolesVOs.add(vo);
		}
		return rolesVOs;
	}

}
