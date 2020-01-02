package com.brijframework.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.application.beans.EOAppRoleDTO;
import com.brijframework.application.model.EOAppRole;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppRoleMapper extends GenericMapper<EOAppRole,EOAppRoleDTO>{
	
	@Override
	@Mapping(source="applicationId" , target="application.id")
	EOAppRole mapToDAO(EOAppRoleDTO eoRoleDTO) ;
	
	@Override
	@Mapping(target="applicationId" , source="application.id")
	EOAppRoleDTO mapToDTO(EOAppRole eoRole) ;

}
