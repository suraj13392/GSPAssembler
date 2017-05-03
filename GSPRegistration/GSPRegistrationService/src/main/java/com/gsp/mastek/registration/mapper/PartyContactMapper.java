package com.gsp.mastek.registration.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.model.PartyContact;
import com.gsp.mastek.registration.vo.PartyContactVO;

@Mapper(uses = { PartycontactPreferenceMapper.class } , componentModel = "spring")
public interface PartyContactMapper {
 
	PartyContactMapper INSTANCE = Mappers.getMapper( PartyContactMapper.class );
 
	PartyContact toPartyContact(PartyContactVO partyContactVO);
    
	@InheritInverseConfiguration
	PartyContactVO fromPartyContact(PartyContact partyContact);
    
	@InheritInverseConfiguration
	List<PartyContactVO> fromPartyContacts(List<PartyContact> partyContacts);
}
