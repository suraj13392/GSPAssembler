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
import com.gsp.mastek.registration.vo.OrganizationAddressResponseVO;
import com.gsp.mastek.registration.vo.OrganizationBusinessResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationDetailsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGoodsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGstnResponseVO;
import com.gsp.mastek.registration.vo.OrganizationServiceResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.PartyAddressResponseVO;
import com.gsp.mastek.registration.vo.PartyContactResponseVO;
import com.gsp.mastek.registration.vo.PartyDetailsResponseVO;
import com.gsp.mastek.registration.vo.PartyResponseVO;
import com.gsp.mastek.registration.vo.RegRequestVO;
import com.gsp.mastek.registration.vo.RegResponseVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;

@Loggable
@RestController
@RequestMapping("/registration")
public class RegistrationServiceController {

	private static @Log Logger logger;

	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = "/saveParty", method = RequestMethod.POST)
	public RegResponseVO<OrganizationVO> saveParty(@RequestBody RegRequestVO<OrganizationVO> savePartyRequestVO) {
		OrganizationVO vo = registrationService.saveOrganization(savePartyRequestVO.getPayload());
		RegResponseVO<OrganizationVO> reponse = new RegResponseVO<OrganizationVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getOrganizationContactDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationContactResponseVO> getOrganizationContactDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationContactResponseVO vo = registrationService.getOrganizationContactDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationContactResponseVO> reponse = new RegResponseVO<OrganizationContactResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getOrganizationBusinessDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationBusinessResponseVO> getOrganizationBusinessDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationBusinessResponseVO vo = registrationService.getOrganizationBusinessDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationBusinessResponseVO> reponse = new RegResponseVO<OrganizationBusinessResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getOrganizationGstin", method = RequestMethod.POST)
	public RegResponseVO<OrganizationGstnResponseVO> getOrganizationGstin(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationGstnResponseVO vo = registrationService.getOrganizationGstin(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationGstnResponseVO> reponse = new RegResponseVO<OrganizationGstnResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getOrganizationDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationDetailsResponseVO> getOrganizationDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationDetailsResponseVO vo = registrationService.getOrganizationDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationDetailsResponseVO> reponse = new RegResponseVO<OrganizationDetailsResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getParty", method = RequestMethod.POST)
	public RegResponseVO<PartyResponseVO> getParty(@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		PartyResponseVO vo = registrationService.getParty(searchRegDtlsCriteriaVO);
		RegResponseVO<PartyResponseVO> reponse = new RegResponseVO<PartyResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getGoodsDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationGoodsResponseVO> getGoodsDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationGoodsResponseVO vo = registrationService.getGoodsDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationGoodsResponseVO> reponse = new RegResponseVO<OrganizationGoodsResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getServiceDetails", method = RequestMethod.POST)
	public RegResponseVO<OrganizationServiceResponseVO> getServiceDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationServiceResponseVO vo = registrationService.getServiceDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationServiceResponseVO> reponse = new RegResponseVO<OrganizationServiceResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getPartyDetails", method = RequestMethod.POST)
	public RegResponseVO<PartyDetailsResponseVO> getPartyDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		PartyDetailsResponseVO vo = registrationService.getPartyDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<PartyDetailsResponseVO> reponse = new RegResponseVO<PartyDetailsResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}

	@RequestMapping(value = "/getPartyAddress", method = RequestMethod.POST)
	public RegResponseVO<PartyAddressResponseVO> getPartyAddress(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		PartyAddressResponseVO vo = registrationService.getPartyAddress(searchRegDtlsCriteriaVO);
		RegResponseVO<PartyAddressResponseVO> response = new RegResponseVO<PartyAddressResponseVO>();
		response.setPayload(vo);
		return response;
	}

	@RequestMapping(value = "/getPartyContactDetails", method = RequestMethod.POST)
	public RegResponseVO<PartyContactResponseVO> getPartyContactDetails(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		PartyContactResponseVO vo = registrationService.getPartyContactDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<PartyContactResponseVO> response = new RegResponseVO<PartyContactResponseVO>();
		response.setPayload(vo);
		return response;
	}

	@RequestMapping(value = "/getOrganizationAddress", method = RequestMethod.POST)
	public RegResponseVO<OrganizationAddressResponseVO> getOrganizationAddress(
			@RequestBody SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		OrganizationAddressResponseVO vo = registrationService.getOrganizationAddressDetails(searchRegDtlsCriteriaVO);
		RegResponseVO<OrganizationAddressResponseVO> reponse = new RegResponseVO<OrganizationAddressResponseVO>();
		reponse.setPayload(vo);
		return reponse;
	}
}
