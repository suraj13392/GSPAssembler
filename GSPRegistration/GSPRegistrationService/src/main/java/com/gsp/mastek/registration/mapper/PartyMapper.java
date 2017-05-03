package com.gsp.mastek.registration.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.vo.OrganizationVO;
import com.gsp.mastek.registration.vo.PartyVO;
import com.gsp.mastek.registration.model.Organization;
import com.gsp.mastek.registration.model.Party;

@Mapper(uses = { PartyAddressMapper.class } , componentModel = "spring")
public interface PartyMapper {
 
	PartyMapper INSTANCE = Mappers.getMapper( PartyMapper.class );
 
	Party toParty(PartyVO partyVO);
    
	@InheritInverseConfiguration
	PartyVO fromParty(Party party);
    
	@InheritInverseConfiguration
	List<PartyVO> fromParties(List<Party> party);
}
