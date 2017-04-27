package com.gsp.mastek.registration.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.model.OrganizationContact;
import com.gsp.mastek.registration.vo.OrganizationContactVO;

@Mapper(uses = { OrganizationContactpreferenceMapper.class } , componentModel = "spring")
public interface OrganizationContactMapper {
 
	OrganizationContactMapper INSTANCE = Mappers.getMapper( OrganizationContactMapper.class );
 
	OrganizationContact toOrganizationContact(OrganizationContactVO organizationContactVO);
    
	@InheritInverseConfiguration
	OrganizationContactVO fromOrganizationContact(OrganizationContact organizationContact);
	
	List<OrganizationContact> toOrganizationContacts(List<OrganizationContactVO> organizationContactVOs);
	    
	@InheritInverseConfiguration
	List<OrganizationContactVO> fromOrganizationContacts(List<OrganizationContact> organizationContacts);
	    
    
}
