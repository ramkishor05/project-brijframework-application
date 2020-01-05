package com.brijframework.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.application.beans.EOAppEditionDTO;
import com.brijframework.application.model.EOAppEdition;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppEditionMapper extends GenericMapper<EOAppEdition,EOAppEditionDTO>{

	@Mapping(source="applicationId", target="application.id")
	@Override
	EOAppEdition mapToDAO(EOAppEditionDTO eoRoleDTO);
	
	@Mapping(source="application.id", target="applicationId")
	@Override
    EOAppEditionDTO mapToDTO(EOAppEdition eoRole);
}
