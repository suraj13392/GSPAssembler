package com.gsp.mastek.registration.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsp.mastek.common.log.Log;
import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.registration.VO.OrganizationVO;

@Loggable
@RestController
public class RegistrationServiceController {

	private static @Log Logger logger;
	
	@RequestMapping(value = "/registration/saveParty", method = RequestMethod.POST)
	public  void saveParty(@RequestBody OrganizationVO organizationVO) {	
		
	}
	
}
