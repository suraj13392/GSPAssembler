package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.model.Organization;

@Mapper(uses = { OrganizationAddressMapper.class, BusinessDtlsMapper.class, GoodsDtlsMapper.class,
		GstnregistrationDtlsMapper.class, ServiceDtlsMapper.class, PartyMapper.class }, componentModel = "spring")
public interface OrganizationMapper {

	OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

	Organization toOrganization(OrganizationVO organizationVO);

	@InheritInverseConfiguration
	OrganizationVO fromOrganization(Organization organization);

}
