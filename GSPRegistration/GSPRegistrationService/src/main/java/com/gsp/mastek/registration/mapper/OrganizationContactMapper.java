package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.OrganizationContactVO;
import com.gsp.mastek.registration.model.OrganizationContact;

@Mapper(uses = { OrganizationContactpreferenceMapper.class } , componentModel = "spring")
public interface OrganizationContactMapper {
 
	OrganizationContactMapper INSTANCE = Mappers.getMapper( OrganizationContactMapper.class );
 
	OrganizationContact toOrganizationContact(OrganizationContactVO organizationContactVO);
    
	@InheritInverseConfiguration
	OrganizationContactVO fromOrganizationContact(OrganizationContact organizationContact);
    
}
