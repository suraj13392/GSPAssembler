package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.PartycontactPreferenceVO;
import com.gsp.mastek.registration.model.PartycontactPreference;

@Mapper(componentModel = "spring")
public interface PartycontactPreferenceMapper {
 
	PartycontactPreferenceMapper INSTANCE = Mappers.getMapper( PartycontactPreferenceMapper.class );
 
	PartycontactPreference toPartycontactPreference(PartycontactPreferenceVO partycontactPreferenceVO);
    
	@InheritInverseConfiguration
	PartycontactPreferenceVO fromPartycontactPreference(PartycontactPreference partycontactPreference);
    
}
