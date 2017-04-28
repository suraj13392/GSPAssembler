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
import com.gsp.mastek.registration.vo.OrganizationBusinessResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGstnResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.RegRequestVO;
import com.gsp.mastek.registration.vo.RegResponseVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;

@Loggable
@RestController
public class RegistrationServiceController {

	private static @Log Logger logger;
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/registration/saveParty", method = RequestMethod.POST)
	public RegResponseVO<OrganizationVO> saveParty(@RequestBody RegRequestVO<OrganizationVO> savePartyRequestVO) {	
		OrganizationVO vo = registrationService.saveOrganization(savePartyRequestVO.getPayload());
		RegResponseVO<OrganizationVO> reponse = new RegResponseVO<OrganizationVO>();
		reponse.setPayload(vo);
		return reponse;
	}
	
	@RequestMapping(value = "/registration/getOrganizationContactDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationContactResponseVO> getOrganizationContactDetails(@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {	
		OrganizationContactResponseVO vo = registrationService.getOrganizationContactDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationContactResponseVO> reponse = new RegResponseVO<OrganizationContactResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}
	
	@RequestMapping(value = "/registration/getParty", method = RequestMethod.POST)
	public RegResponseVO<OrganizationVO> getParty(@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {	
		OrganizationVO respVO = registrationService.getParty(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationVO> reponse = new RegResponseVO<OrganizationVO>();
		reponse.setPayload(respVO);
		return reponse;
	}
	
	@RequestMapping(value = "/registration/getOrganizationBusinessDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationBusinessResponseVO> getOrganizationBusinessDetails(@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {	
		OrganizationBusinessResponseVO vo = registrationService.getOrganizationBusinessDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationBusinessResponseVO> reponse = new RegResponseVO<OrganizationBusinessResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}
	
	@RequestMapping(value = "/registration/getOrganizationGstin", method = RequestMethod.POST)
	public RegResponseVO<OrganizationGstnResponseVO> getOrganizationGstin(@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {	
		OrganizationGstnResponseVO vo = registrationService.getOrganizationGstin(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationGstnResponseVO> reponse = new RegResponseVO<OrganizationGstnResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}
	
	
}
