package com.gsp.mastek.registration.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.BusinessDtlsVO;
import com.gsp.mastek.registration.model.BusinessDtls;

@Mapper(componentModel = "spring")
public interface BusinessDtlsMapper {
 
	BusinessDtlsMapper INSTANCE = Mappers.getMapper( BusinessDtlsMapper.class );
 
	BusinessDtls toBusinessDtls(BusinessDtlsVO businessDtlsVO);
    
	@InheritInverseConfiguration
	BusinessDtlsVO fromBusinessDtls(BusinessDtls businessDtls);
    
}
