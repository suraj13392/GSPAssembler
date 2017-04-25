package com.gsp.mastek.registration.service.impl;

import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsp.mastek.common.log.Loggable;
import com.gsp.mastek.registration.VO.GoodsDtlsVO;
import com.gsp.mastek.registration.VO.GstnregistrationDtlsVO;
import com.gsp.mastek.registration.VO.OrganizationVO;
import com.gsp.mastek.registration.VO.ServiceDtlsVO;
import com.gsp.mastek.registration.mapper.GoodsDtlsMapper;
import com.gsp.mastek.registration.mapper.GstnregistrationDtlsMapper;
import com.gsp.mastek.registration.mapper.OrganizationMapper;
import com.gsp.mastek.registration.mapper.ServiceDtlsMapper;
import com.gsp.mastek.registration.model.GstnregistrationDtls;
import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.repository.GoodsDtlsRepository;
import com.gsp.mastek.registration.repository.GstnregistrationDtlsRepository;
import com.gsp.mastek.registration.repository.OrganizationRepository;
import com.gsp.mastek.registration.repository.ServiceDtlsRepository;

@Service
@Loggable
public class RegistrationServiceImpl {
	
	@Autowired
	private OrganizationRepository organizationRepository;	
	@Autowired
	private GoodsDtlsRepository goodsDtlsRepository ;
	@Autowired
	private ServiceDtlsRepository serviceDtlsRepository ;
	@Autowired
	private GstnregistrationDtlsRepository gstnregistrationDtlsRepository ;
	@Autowired
	private OrganizationMapper organizationMapper ;
	@Autowired
	private GstnregistrationDtlsMapper gstnregistrationDtlsMapper ;
	@Autowired
	private ServiceDtlsMapper serviceDtlsMapper ;
	@Autowired
	private GoodsDtlsMapper goodsDtlsMapper ;
	
	public void saveOrganization(OrganizationVO organizationVO){
		Organization organization = organizationMapper.toOrganization(organizationVO);
		organization = organizationRepository.save(organization);
		saveGoodsDtls(organizationVO.getGoodsDtlses() , organization);
		saveServiceDtls(organizationVO.getServiceDtlses() , organization);
		saveGstnregistrationDtls(organizationVO.getGstnregistrationDtlses() , organization);
	}

	private void saveGstnregistrationDtls(Set<GstnregistrationDtlsVO> gstnregistrationDtlsVOs,
			Organization organization) {
		if(CollectionUtils.isNotEmpty(gstnregistrationDtlsVOs)){
			Set<GstnregistrationDtls> gstnregistrationDtlses = gstnregistrationDtlsMapper.toGstnregistrationDtlses(gstnregistrationDtlsVOs);
			gstnregistrationDtlses.stream().forEach(o -> o.setOrganization(organization));
			gstnregistrationDtlsRepository.save(gstnregistrationDtlses);
		}
		
	}

	private void saveServiceDtls(Set<ServiceDtlsVO> serviceDtlses, Organization organization) {
		if (CollectionUtils.isNotEmpty(serviceDtlses)) {

		}
		
	}

	private void saveGoodsDtls(Set<GoodsDtlsVO> goodsDtlses, Organization organization) {
		if (CollectionUtils.isNotEmpty(goodsDtlses)) {

		}
		
	}
}
