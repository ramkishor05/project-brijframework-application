package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOAppRoleDTO;
import com.brijframework.application.entities.EOAppRole;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppRoleMapper extends GenericMapper<EOAppRole,EOAppRoleDTO>{

}
