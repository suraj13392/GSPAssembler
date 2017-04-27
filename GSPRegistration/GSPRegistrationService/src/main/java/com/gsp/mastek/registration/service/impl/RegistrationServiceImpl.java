package com.gsp.mastek.registration.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.registration.mapper.GoodsDtlsMapper;
import com.gsp.mastek.registration.mapper.GstnregistrationDtlsMapper;
import com.gsp.mastek.registration.mapper.OrganizationContactMapper;
import com.gsp.mastek.registration.mapper.OrganizationMapper;
import com.gsp.mastek.registration.mapper.ServiceDtlsMapper;
import com.gsp.mastek.registration.model.GoodsDtls;
import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.model.OrganizationAddress;
import com.gsp.mastek.registration.model.OrganizationContact;
import com.gsp.mastek.registration.model.ServiceDtls;
import com.gsp.mastek.registration.repository.GoodsDtlsRepository;
import com.gsp.mastek.registration.repository.OrganizationRepository;
import com.gsp.mastek.registration.repository.ServiceDtlsRepository;
import com.gsp.mastek.registration.service.RegistrationService;
import com.gsp.mastek.registration.vo.GoodsDtlsVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;
import com.gsp.mastek.registration.vo.ServiceDtlsVO;

@Service
@Loggable
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;	
	@Autowired
	private GoodsDtlsRepository goodsDtlsRepository ;
	@Autowired
	private ServiceDtlsRepository serviceDtlsRepository ;
	/*@Autowired
	private GstnregistrationDtlsRepository gstnregistrationDtlsRepository ;*/
	@Autowired
	private OrganizationMapper organizationMapper ;
	@Autowired
	private GstnregistrationDtlsMapper gstnregistrationDtlsMapper ;
	@Autowired
	private ServiceDtlsMapper serviceDtlsMapper ;
	@Autowired
	private GoodsDtlsMapper goodsDtlsMapper ;
	@Autowired
	private OrganizationContactMapper  organizationContactMapper;
	/* (non-Javadoc)
	 * @see com.gsp.mastek.registration.service.impl.RegistrationService#saveOrganization(com.gsp.mastek.registration.VO.OrganizationVO)
	 */
	@Transactional
	@Override
	public OrganizationVO saveOrganization(OrganizationVO organizationVO){
		Organization organization = organizationMapper.toOrganization(organizationVO);
		organization = organizationRepository.save(organization);
		Set<GoodsDtlsVO> goodsDtlsVOs = saveGoodsDtls(organizationVO.getGoodsDtlses() , organization);
		Set<ServiceDtlsVO> serviceDtlsVOs = saveServiceDtls(organizationVO.getServiceDtlses() , organization);
		//Set<GstnregistrationDtlsVO> gstnregistrationDtlsVOs = saveGstnregistrationDtls(organizationVO.getGstnregistrationDtlses() , organization);
		
		OrganizationVO output = organizationMapper.fromOrganization(organization);
		output.setGoodsDtlses(goodsDtlsVOs);
		//output.setGstnregistrationDtlses(gstnregistrationDtlsVOs);
		output.setServiceDtlses(serviceDtlsVOs);
		return output;
	}

	/*private Set<GstnregistrationDtlsVO> saveGstnregistrationDtls(Set<GstnregistrationDtlsVO> gstnregistrationDtlsVOs,
			Organization organization) {
		if(CollectionUtils.isNotEmpty(gstnregistrationDtlsVOs)){
			Set<GstnregistrationDtls> gstnregistrationDtlses = gstnregistrationDtlsMapper.toGstnregistrationDtlses(gstnregistrationDtlsVOs);
			gstnregistrationDtlses.stream().forEach(o -> o.setOrganization(organization));
			List<GstnregistrationDtls> gstnregistrationDtlsList = (List<GstnregistrationDtls>) gstnregistrationDtlsRepository.save(gstnregistrationDtlses);
			gstnregistrationDtlses = new HashSet<>(gstnregistrationDtlsList);
			Set<GstnregistrationDtlsVO> output = gstnregistrationDtlsMapper.fromGstnregistrationDtlses(gstnregistrationDtlses);
			return output;
		}
		return null;
	}*/

	private Set<ServiceDtlsVO> saveServiceDtls(Set<ServiceDtlsVO> serviceDtlsVOs, Organization organization) {
		if (CollectionUtils.isNotEmpty(serviceDtlsVOs)) {
			Set<ServiceDtls> serviceDtlses = serviceDtlsMapper.toServiceDtlses(serviceDtlsVOs);
			serviceDtlses.stream().forEach(o -> o.setOrganization(organization));
			List<ServiceDtls> serviceDtlsList = (List<ServiceDtls>)serviceDtlsRepository.save(serviceDtlses);
			serviceDtlses = new HashSet<>(serviceDtlsList);
			Set<ServiceDtlsVO> output = serviceDtlsMapper.fromServiceDtlses(serviceDtlses);
			return output;
		}
		return null;
	}

	private Set<GoodsDtlsVO> saveGoodsDtls(Set<GoodsDtlsVO> goodsDtlsVOs, Organization organization) {
		if (CollectionUtils.isNotEmpty(goodsDtlsVOs)) {
			Set<GoodsDtls> goodsDtlses = goodsDtlsMapper.toGoodsDtlses(goodsDtlsVOs);
			goodsDtlses.stream().forEach(o -> o.setOrganization(organization));
			List<GoodsDtls> goodsDtlsList = (List<GoodsDtls>) goodsDtlsRepository.save(goodsDtlses);
			goodsDtlses = new HashSet<>(goodsDtlsList);
			Set<GoodsDtlsVO> output = goodsDtlsMapper.fromGoodsDtlses(goodsDtlses);
			return output;
		}
		return null;
	}

	@Override
	public OrganizationContactResponseVO getOrganizationContactDetails(
			SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		
		Organization organization = organizationRepository.findBySearchCriteria(searchRegDtlsCriteriaVO.getOrganizationId(),
				searchRegDtlsCriteriaVO.getGstin(),searchRegDtlsCriteriaVO.getAadharNumber(),searchRegDtlsCriteriaVO.getPanNumber(),
				searchRegDtlsCriteriaVO.getPartyId(),searchRegDtlsCriteriaVO.getPartyStatus(),searchRegDtlsCriteriaVO.getUserName()
				);
		List<OrganizationContact> allContacts = new ArrayList<OrganizationContact>();
		if(organization != null){
			if(organization.getOrganizationAddresses() != null){				
				for( OrganizationAddress oa :organization.getOrganizationAddresses()){
					if(oa.getOrganizationContacts() != null) {
					 allContacts.addAll(oa.getOrganizationContacts());
					}
				}
			}
		}
		OrganizationContactResponseVO reponse = new OrganizationContactResponseVO();
		List<OrganizationContactVO> allContactVOs = organizationContactMapper.fromOrganizationContacts(allContacts);
		reponse.setContactDetails(allContactVOs);
		return reponse;
	}
}
