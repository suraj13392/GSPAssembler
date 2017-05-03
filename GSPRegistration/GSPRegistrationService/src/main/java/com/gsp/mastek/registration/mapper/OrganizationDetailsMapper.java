package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.vo.OrganizationDetailsResponseVO;
import com.gsp.mastek.registration.vo.OrganizationVO;

@Mapper(uses = { OrganizationAddressMapper.class, BusinessDtlsMapper.class, GoodsDtlsMapper.class,
		GstnregistrationDtlsMapper.class, ServiceDtlsMapper.class, PartyMapper.class }, componentModel = "spring")
public interface OrganizationDetailsMapper {

	OrganizationDetailsMapper INSTANCE = Mappers.getMapper(OrganizationDetailsMapper.class);
	
	@InheritInverseConfiguration
	OrganizationDetailsResponseVO fromOrganization(Organization organization);
	
}
