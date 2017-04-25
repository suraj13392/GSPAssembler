package com.gsp.mastek.registration.mapper;

import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.VO.GoodsDtlsVO;
import com.gsp.mastek.registration.model.GoodsDtls;

@Mapper(componentModel = "spring")
public interface GoodsDtlsMapper {
 
	GoodsDtlsMapper INSTANCE = Mappers.getMapper( GoodsDtlsMapper.class );
 
	GoodsDtls toGoodsDtls(GoodsDtlsVO goodsDtlsVO);
    
	@InheritInverseConfiguration
	GoodsDtlsVO fromGoodsDtls(GoodsDtls goodsDtls);
	
	Set<GoodsDtls> toGoodsDtlses(Set<GoodsDtlsVO> goodsDtlsVOs);
    
	@InheritInverseConfiguration
	Set<GoodsDtlsVO> fromGoodsDtlses(Set<GoodsDtls> goodsDtlses);
    
}
