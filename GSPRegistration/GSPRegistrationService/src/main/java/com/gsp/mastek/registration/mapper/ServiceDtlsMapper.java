package com.gsp.mastek.registration.mapper;

import java.util.Set;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.registration.vo.ServiceDtlsVO;
import com.gsp.mastek.registration.model.ServiceDtls;

@Mapper(componentModel = "spring")
public interface ServiceDtlsMapper {
 
	ServiceDtlsMapper INSTANCE = Mappers.getMapper( ServiceDtlsMapper.class );
 
	ServiceDtls toServiceDtls(ServiceDtlsVO serviceDtlsVO);
    
	@InheritInverseConfiguration
	ServiceDtlsVO fromServiceDtls(ServiceDtls serviceDtls);
	
	Set<ServiceDtls> toServiceDtlses(Set<ServiceDtlsVO> serviceDtlsVOs);
    
	@InheritInverseConfiguration
	Set<ServiceDtlsVO> fromServiceDtlses(Set<ServiceDtls> serviceDtlses);
    
}
