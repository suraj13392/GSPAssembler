package com.gsp.mastek.registration.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.model.GstnregistrationDtls;
import com.gsp.mastek.registration.vo.GstnregistrationDtlsVO;

@Mapper(componentModel = "spring")
public interface GstnregistrationDtlsMapper {
 
	GstnregistrationDtlsMapper INSTANCE = Mappers.getMapper( GstnregistrationDtlsMapper.class );
 
	GstnregistrationDtls toGstnregistrationDtls(GstnregistrationDtlsVO gstnregistrationDtlsVO);
    
	@InheritInverseConfiguration
	GstnregistrationDtlsVO fromGstnregistrationDtls(GstnregistrationDtls gstnregistrationDtls);
	
    Set<GstnregistrationDtls> toGstnregistrationDtlses(Set<GstnregistrationDtlsVO> gstnregistrationDtlsVOs);
    
	@InheritInverseConfiguration
	Set<GstnregistrationDtlsVO> fromGstnregistrationDtlses(Set<GstnregistrationDtls> gstnregistrationDtlses);
	
	@InheritInverseConfiguration
	List<GstnregistrationDtlsVO> fromGstnregistrationDtlses(List<GstnregistrationDtls> gstnregistrationDtlses);
    
}
