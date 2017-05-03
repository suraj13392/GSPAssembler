package com.gsp.mastek.registration.service;

import com.gsp.mastek.registration.vo.OrganizationBusinessResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationDetailsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGoodsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGstnResponseVO;
import com.gsp.mastek.registration.vo.OrganizationServiceResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.PartyDetailsResponseVO;
import com.gsp.mastek.registration.vo.PartyResponseVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;

public interface RegistrationService {

	OrganizationVO saveOrganization(OrganizationVO organizationVO);

	OrganizationContactResponseVO getOrganizationContactDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	OrganizationBusinessResponseVO getOrganizationBusinessDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);

	OrganizationGstnResponseVO getOrganizationGstin(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	OrganizationDetailsResponseVO getOrganizationDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);

	PartyResponseVO getParty(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	OrganizationGoodsResponseVO getGoodsDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	OrganizationServiceResponseVO getServiceDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	PartyDetailsResponseVO getPartyDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
}