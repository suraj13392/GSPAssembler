package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.PartyAddressVO;
import com.gsp.mastek.registration.model.PartyAddress;

@Mapper(uses = { PartyContactMapper.class } , componentModel = "spring")
public interface PartyAddressMapper {
 
	PartyAddressMapper INSTANCE = Mappers.getMapper( PartyAddressMapper.class );
 
	PartyAddress toPartyAddress(PartyAddressVO partyAddressVO);
    
	@InheritInverseConfiguration
	PartyAddressVO fromPartyAddress(PartyAddress partyAddress);
    
}
