package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.OrganizationContactpreferenceVO;
import com.gsp.mastek.registration.model.OrganizationContactpreference;

@Mapper(componentModel = "spring")
public interface OrganizationContactpreferenceMapper {
 
	OrganizationContactpreferenceMapper INSTANCE = Mappers.getMapper( OrganizationContactpreferenceMapper.class );
 
	OrganizationContactpreference toOrganizationContactpreference(OrganizationContactpreferenceVO organizationContactpreferenceVO);
    
	@InheritInverseConfiguration
	OrganizationContactpreferenceVO fromOrganizationContactpreference(OrganizationContactpreference organizationContactpreference);
    
}
