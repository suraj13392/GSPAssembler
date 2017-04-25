package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.PartyContactVO;
import com.gsp.mastek.registration.model.PartyContact;

@Mapper(uses = { PartycontactPreferenceMapper.class } , componentModel = "spring")
public interface PartyContactMapper {
 
	PartyContactMapper INSTANCE = Mappers.getMapper( PartyContactMapper.class );
 
	PartyContact toPartyContact(PartyContactVO partyContactVO);
    
	@InheritInverseConfiguration
	PartyContactVO fromPartyContact(PartyContact partyContact);
    
}
