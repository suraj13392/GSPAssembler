package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.PartyVO;
import com.gsp.mastek.registration.model.Party;

@Mapper(uses = { PartyAddressMapper.class } , componentModel = "spring")
public interface PartyMapper {
 
	PartyMapper INSTANCE = Mappers.getMapper( PartyMapper.class );
 
	Party toParty(PartyVO partyVO);
    
	@InheritInverseConfiguration
	PartyVO fromParty(Party party);
    
}
