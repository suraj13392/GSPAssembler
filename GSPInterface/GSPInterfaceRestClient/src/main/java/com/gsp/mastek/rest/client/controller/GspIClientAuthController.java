package com.gsp.mastek.rest.client.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gsp.mastek.rest.client.common.GSPInterfaceConstant;
import com.gsp.mastek.rest.client.service.GSPInterfaceClientService;
import com.gsp.mastek.rest.client.vo.OTPRequestVO;

@RestController
public class GspIClientAuthController {
	
	private static final Logger logger = Logger.getLogger(GspIClientAuthController.class);
	public static final String IP_USR = "ip-usr";
	public static final String STATE_CD = "state-cd";
	
	@Autowired
	private GSPInterfaceClientService gspInterfaceClientService;
	
	@RequestMapping(value = "/taxpayerapi/getotp", method = RequestMethod.POST)
	public Object getOTP(@RequestBody OTPRequestVO otpRequestVO, 
			@RequestHeader(value="ip-usr") String ipUser, @RequestHeader(value="state-cd") String stateCode) throws Exception {
		logger.info("getOTP:::::otpRequestVO: " + otpRequestVO + " ipUser:" + ipUser + " stateCode:" +stateCode );
		//otpRequestVO.putHeaderValues(IP_USR,ipUser);
		otpRequestVO.putHeaderValues(STATE_CD,stateCode);
		return gspInterfaceClientService.requestService(GSPInterfaceConstant.ServiceName.OTPRequestService, otpRequestVO);
	}

}
