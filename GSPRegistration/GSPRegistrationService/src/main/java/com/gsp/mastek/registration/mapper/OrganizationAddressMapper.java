package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.OrganizationAddressVO;
import com.gsp.mastek.registration.model.OrganizationAddress;

@Mapper(uses = { OrganizationContactMapper.class } , componentModel = "spring")
public interface OrganizationAddressMapper {
 
	OrganizationAddressMapper INSTANCE = Mappers.getMapper( OrganizationAddressMapper.class );
 
	OrganizationAddress toOrganizationAddress(OrganizationAddressVO organizationAddressVO);
    
	@InheritInverseConfiguration
	OrganizationAddressVO fromOrganizationAddress(OrganizationAddress organizationAddress);
    
}
