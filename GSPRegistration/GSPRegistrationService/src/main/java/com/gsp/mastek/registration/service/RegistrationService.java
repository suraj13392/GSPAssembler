package com.gsp.mastek.registration.service;

import com.gsp.mastek.registration.vo.OrganizationBusinessResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGstnResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;

public interface RegistrationService {

	OrganizationVO saveOrganization(OrganizationVO organizationVO);

	OrganizationContactResponseVO getOrganizationContactDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);
	
	OrganizationBusinessResponseVO getOrganizationBusinessDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);

	OrganizationGstnResponseVO getOrganizationGstin(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);

	OrganizationVO getParty(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO);

}