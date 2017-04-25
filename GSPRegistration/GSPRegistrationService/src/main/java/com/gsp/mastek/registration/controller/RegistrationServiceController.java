package com.gsp.mastek.registration.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.registration.VO.SavePartyReqVO;

@Loggable
@RestController
public class RegistrationServiceController {

	private static final Logger logger = Logger.getLogger(RegistrationServiceController.class);
	
	@RequestMapping(value = "/saveParty", method = RequestMethod.POST)
	public  void saveParty(@RequestBody SavePartyReqVO savePartyReqVO) {	
		logger.info("rolesVO coming " + savePartyReqVO);
		logger.debug("This is debug log");
		logger.info("mstenv is " + savePartyReqVO);
		logger.info("myenv is " + savePartyReqVO);
		
		return ;
	}
	
}
