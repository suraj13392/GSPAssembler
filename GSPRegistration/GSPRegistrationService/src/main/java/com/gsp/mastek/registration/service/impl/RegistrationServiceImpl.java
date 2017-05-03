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
import com.gsp.mastek.registration.mapper.BusinessDtlsMapper;
import com.gsp.mastek.registration.mapper.GoodsDtlsMapper;
import com.gsp.mastek.registration.mapper.GstnregistrationDtlsMapper;
import com.gsp.mastek.registration.mapper.OrganizationAddressMapper;
import com.gsp.mastek.registration.mapper.OrganizationContactMapper;
import com.gsp.mastek.registration.mapper.OrganizationDetailsMapper;
import com.gsp.mastek.registration.mapper.OrganizationMapper;
import com.gsp.mastek.registration.mapper.PartyAddressMapper;
import com.gsp.mastek.registration.mapper.PartyContactMapper;
import com.gsp.mastek.registration.mapper.PartyMapper;
import com.gsp.mastek.registration.mapper.ServiceDtlsMapper;
import com.gsp.mastek.registration.model.BusinessDtls;
import com.gsp.mastek.registration.model.GoodsDtls;
import com.gsp.mastek.registration.model.GstnregistrationDtls;
import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.model.OrganizationAddress;
import com.gsp.mastek.registration.model.OrganizationContact;
import com.gsp.mastek.registration.model.Party;
import com.gsp.mastek.registration.model.PartyAddress;
import com.gsp.mastek.registration.model.PartyContact;
import com.gsp.mastek.registration.model.ServiceDtls;
import com.gsp.mastek.registration.repository.BusinessDtlsRepository;
import com.gsp.mastek.registration.repository.GoodsDtlsRepository;
import com.gsp.mastek.registration.repository.OrganizationRepository;
import com.gsp.mastek.registration.repository.ServiceDtlsRepository;
import com.gsp.mastek.registration.service.RegistrationService;
import com.gsp.mastek.registration.specification.OrganizationSpecs;
import com.gsp.mastek.registration.vo.BusinessDtlsVO;
import com.gsp.mastek.registration.vo.GoodsDtlsVO;
import com.gsp.mastek.registration.vo.GstnregistrationDtlsVO;
import com.gsp.mastek.registration.vo.OrganizationAddressVO;
import com.gsp.mastek.registration.vo.OrganizationBusinessResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactResponseVO;
import com.gsp.mastek.registration.vo.OrganizationContactVO;
import com.gsp.mastek.registration.vo.OrganizationDetailsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGoodsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationGstnResponseVO;
import com.gsp.mastek.registration.vo.OrganizationServiceResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.PartyAddressResponseVO;
import com.gsp.mastek.registration.vo.PartyAddressVO;
import com.gsp.mastek.registration.vo.PartyContactResponseVO;
import com.gsp.mastek.registration.vo.PartyContactVO;
import com.gsp.mastek.registration.vo.PartyDetailsResponseVO;
import com.gsp.mastek.registration.vo.PartyResponseVO;
import com.gsp.mastek.registration.vo.PartyVO;
import com.gsp.mastek.registration.vo.SearchRegDtlsCriteriaVO;
import com.gsp.mastek.registration.vo.ServiceDtlsVO;

@Service
@Loggable
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	@Autowired
	private GoodsDtlsRepository goodsDtlsRepository;
	@Autowired
	private ServiceDtlsRepository serviceDtlsRepository;
	@Autowired
	private BusinessDtlsRepository businessDtlsRepository;
	@Autowired
	private OrganizationMapper organizationMapper;
	@Autowired
	private GstnregistrationDtlsMapper gstnregistrationDtlsMapper;
	@Autowired
	private ServiceDtlsMapper serviceDtlsMapper;
	@Autowired
	private GoodsDtlsMapper goodsDtlsMapper;
	@Autowired
	private OrganizationContactMapper organizationContactMapper;
	@Autowired
	private OrganizationAddressMapper  organizationAddressMapper;
	@Autowired
	private BusinessDtlsMapper businessDtlsMapper;
	@Autowired
	private PartyMapper partyMapper;
	@Autowired
	private OrganizationDetailsMapper organizationDetailsMapper;
	@Autowired
	private PartyContactMapper partyContactMapper;
	@Autowired
	private PartyAddressMapper partyAddressMapper;
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gsp.mastek.registration.service.impl.RegistrationService#
	 * saveOrganization(com.gsp.mastek.registration.VO.OrganizationVO)
	 */
	@Transactional
	@Override
	public OrganizationVO saveOrganization(OrganizationVO organizationVO) {
		Organization organization = organizationMapper.toOrganization(organizationVO);
		organization = organizationRepository.save(organization);
		saveBusinessDtls(organizationVO.getBusinessDtls(), organization);
		Set<GoodsDtlsVO> goodsDtlsVOs = saveGoodsDtls(organizationVO.getGoodsDtlses(), organization);
		Set<ServiceDtlsVO> serviceDtlsVOs = saveServiceDtls(organizationVO.getServiceDtlses(), organization);
		OrganizationVO output = organizationMapper.fromOrganization(organization);
		output.setGoodsDtlses(goodsDtlsVOs);
		output.setServiceDtlses(serviceDtlsVOs);
		return output;
	}	

	private void saveBusinessDtls(BusinessDtlsVO businessDtlsVO, Organization organization) {
		if (businessDtlsVO != null ) {
			BusinessDtls businessDtls = businessDtlsMapper.toBusinessDtls(businessDtlsVO);
			businessDtls.setOrganization(organization);
			businessDtls =  businessDtlsRepository.save(businessDtls);
			organization.setBusinessDtls(businessDtls);
		}
	}


	private Set<ServiceDtlsVO> saveServiceDtls(Set<ServiceDtlsVO> serviceDtlsVOs, Organization organization) {
		if (CollectionUtils.isNotEmpty(serviceDtlsVOs)) {
			Set<ServiceDtls> serviceDtlses = serviceDtlsMapper.toServiceDtlses(serviceDtlsVOs);
			serviceDtlses.stream().forEach(o -> o.setOrganization(organization));
			List<ServiceDtls> serviceDtlsList = (List<ServiceDtls>) serviceDtlsRepository.save(serviceDtlses);
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

		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
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

	@Override
	public OrganizationBusinessResponseVO getOrganizationBusinessDetails(
			SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		Organization organization = organizationRepository.findOne(searchRegDtlsCriteriaVO.getOrganizationId());
		BusinessDtls businessDtl = new BusinessDtls();
		if (organization != null) {
			if (organization.getBusinessDtls() != null) {
				businessDtl = organization.getBusinessDtls();
			}
		}
		BusinessDtlsVO reponseVO = businessDtlsMapper.fromBusinessDtls(businessDtl);
		OrganizationBusinessResponseVO response = new OrganizationBusinessResponseVO();
		response.setBusinessDtls(reponseVO);

		return response;
	}

	@Override
	public OrganizationGstnResponseVO getOrganizationGstin(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		Organization organization = organizationRepository.findOne(searchRegDtlsCriteriaVO.getOrganizationId());
		List<GstnregistrationDtls> GstnregistrationDtls = new ArrayList<GstnregistrationDtls>();
		if (organization != null) {
			if(organization.getGstnregistrationDtlses()!=null){
				GstnregistrationDtls.addAll(organization.getGstnregistrationDtlses());
			}
		}
		List<GstnregistrationDtlsVO> GstnregistrationVOs=gstnregistrationDtlsMapper.fromGstnregistrationDtlses(GstnregistrationDtls);
		OrganizationGstnResponseVO responseVO = new OrganizationGstnResponseVO();
		responseVO.setGstnregistrationDtlses(GstnregistrationVOs);
		return responseVO;
	}

	
	/*Added By Priyanka*/
	
	@Override
	public OrganizationDetailsResponseVO getOrganizationDetails(
			SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		
		List<OrganizationAddress> allAddress = new ArrayList<OrganizationAddress>();
		
		if(organization != null){
			if(organization.getOrganizationAddresses() != null){	
			
					allAddress.addAll(organization.getOrganizationAddresses());
			}
		}
	
		OrganizationDetailsResponseVO response=organizationDetailsMapper.fromOrganization(organization);
		List<OrganizationAddressVO> allAddressVOs = organizationAddressMapper.fromOrganizationAddresses(allAddress);
		response.setAddressDetails(allAddressVOs);		
		return response;
	}
	
	@Override
	public PartyResponseVO getParty(
			SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		Set<GoodsDtlsVO> goodsVOs = null;
		Set<ServiceDtlsVO> serviceVOs = null;
		Organization allOranization = new Organization();
		if(organization != null){
			goodsVOs=goodsDetails(organization.getOrganizationId());
			serviceVOs=serviceDetails(organization.getOrganizationId());
			allOranization=organization;
		}
		PartyResponseVO response=new  PartyResponseVO();
		OrganizationVO allOraganizationVOs = organizationMapper.fromOrganization(allOranization);
		allOraganizationVOs.setGoodsDtlses(goodsVOs);
		allOraganizationVOs.setServiceDtlses(serviceVOs);
		response.setOrganizationDetails(allOraganizationVOs);
		return response;
	}



	@Override
	public OrganizationGoodsResponseVO getGoodsDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		Set<GoodsDtlsVO> goodsVOs = null;
		if(organization != null){
			goodsVOs=goodsDetails(organization.getOrganizationId());
		}
		OrganizationGoodsResponseVO response=new OrganizationGoodsResponseVO();
		response.setGoodsDetails(goodsVOs);
		response.setOrganizationId(organization.getOrganizationId());
		return response;
	}

	private Set<GoodsDtlsVO> goodsDetails(Long organizationId){
		Set<GoodsDtls> goodsDtlsList =(Set<GoodsDtls>)goodsDtlsRepository.findByOrganizationId(organizationId);
		Set<GoodsDtlsVO> goodsVOs =goodsDtlsMapper.fromGoodsDtlses(goodsDtlsList);
		return goodsVOs;
		
	}

	@Override
	public OrganizationServiceResponseVO getServiceDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
	
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		Set<ServiceDtlsVO> serviceVOs = null;
		if(organization != null){
	
		 		serviceVOs=serviceDetails(organization.getOrganizationId());
		}
		OrganizationServiceResponseVO response=new OrganizationServiceResponseVO();
		response.setServiceDetails(serviceVOs);
		response.setOrganizationId(organization.getOrganizationId());
		return response;
	}
	
	private Set<ServiceDtlsVO> serviceDetails(Long organizationId){
		Set<ServiceDtls>  serviceDtlsList = (Set<ServiceDtls>)serviceDtlsRepository.findByOrganizationId(organizationId);
		Set<ServiceDtlsVO> serviceVOs=serviceDtlsMapper.fromServiceDtlses(serviceDtlsList);
		return serviceVOs;
	}



	@Override
	public PartyDetailsResponseVO getPartyDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		
		List<Party> allParties = new ArrayList<Party>();
		if(organization != null){
			if(organization.getParties()!=null){
				allParties.addAll(organization.getParties());
			}
		}
		PartyDetailsResponseVO response=new PartyDetailsResponseVO();
		List<PartyVO> allPartyVOs = partyMapper.fromParties(allParties);
		response.setParty(allPartyVOs);
		return response;
	}
	
	@Override
	public PartyAddressResponseVO getPartyAddress(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {

		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		
		List<Party> parties = new ArrayList<Party>();
		List<PartyAddress> partyAddresses = new ArrayList<PartyAddress>();
		
		if(organization != null){
			if(organization.getParties()!= null){
				parties.addAll(organization.getParties());
			}
		}
		
		if(parties != null){
			for (Party party : parties) {
			if(organization.getOrganizationAddresses() != null){				
						partyAddresses.addAll(party.getPartyAddresses());
			}
		}
	}
		
		PartyAddressResponseVO response = new PartyAddressResponseVO();
		List<PartyAddressVO> allAddressVOs = partyAddressMapper.fromPartyAddresses(partyAddresses);
		response.setAddress(allAddressVOs);
		return response;
	}

	@Override
	public PartyContactResponseVO getPartyContactDetails(SearchRegDtlsCriteriaVO searchRegDtlsCriteriaVO) {
		
		List<Organization> organizations = organizationRepository.findAll(OrganizationSpecs.findByCriteria(searchRegDtlsCriteriaVO));
		Organization organization = organizations.get(0);
		
		List<Party> parties = new ArrayList<Party>();
		List<PartyContact> partyContacts = new ArrayList<PartyContact>();
		
		if(organization != null){
			if(organization.getParties()!= null){
				parties.addAll(organization.getParties());
			}
		}
		
		if(parties!=null){
			for (Party party : parties) {
				for (PartyAddress PartyAddress:party.getPartyAddresses()) {
					partyContacts.addAll(PartyAddress.getPartyContacts());
				}
			}
		}
		
		PartyContactResponseVO response = new PartyContactResponseVO();
		List<PartyContactVO> partyContactVOs = partyContactMapper.fromPartyContacts(partyContacts);
		response.setContactDetails(partyContactVOs);
		return response;
	}
}
