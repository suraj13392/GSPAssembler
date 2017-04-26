package com.gsp.mastek.registration.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsp.mastek.common.log.Log;
import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.registration.service.RegistrationService;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.SavePartyRequestVO;
import com.gsp.mastek.registration.vo.SavePartyResponseVO;

@Loggable
@RestController
public class RegistrationServiceController {

	private static @Log Logger logger;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/registration/saveParty", method = RequestMethod.POST)
	public SavePartyResponseVO saveParty(@RequestBody SavePartyRequestVO savePartyRequestVO) {	
		OrganizationVO vo = registrationService.saveOrganization(savePartyRequestVO.getOrganizationDetails());
		SavePartyResponseVO reponse = new SavePartyResponseVO();
		reponse.setOrganizationDetails(vo);
		return reponse;
	}
	
}
