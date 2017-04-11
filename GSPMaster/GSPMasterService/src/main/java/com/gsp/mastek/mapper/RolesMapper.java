package com.gsp.mastek.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.gsp.mastek.master.model.Roles;
import com.gsp.mastek.master.vo.RolesVO;

//@Mapper(uses = { RolesMapper.class }, componentModel = "spring")
@Mapper(componentModel = "spring")
public interface RolesMapper {
 
    RolesMapper INSTANCE = Mappers.getMapper( RolesMapper.class );
 
    RolesVO rolesToRolesVO(Roles roles);
    
    Roles rolesVOToRoles(RolesVO rolesVO);
}
