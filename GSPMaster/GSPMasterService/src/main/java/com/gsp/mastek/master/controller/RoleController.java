package com.gsp.mastek.master.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsp.mastek.master.service.RoleService;
import com.gsp.mastek.master.vo.RolesVO;


@RestController
public class RoleController {
	
	private static final Logger logger = Logger.getLogger(RoleController.class);
	
	@Value("${mstenv}")
    private String mstenv ;
	
	@Value("${myenv}")
    private String myenv ;
    
	@Autowired
	private RoleService roleService ;
	
	@RequestMapping(value = "/saveRoles", method = RequestMethod.POST)
	public RolesVO saveroles(@RequestBody RolesVO rolesVO) {	
		logger.info("rolesVO coming " + rolesVO);
		logger.debug("This is debug log");
		logger.info("mstenv is " + mstenv);
		logger.info("myenv is " + myenv);
		roleService.save(rolesVO);
		return rolesVO;
	}

	
	@RequestMapping(value = "/fetchAllRoles", method = RequestMethod.GET)
	public List<RolesVO> fetchAllRoles() {
		return roleService.fetchAllRoles();
	}	

}
