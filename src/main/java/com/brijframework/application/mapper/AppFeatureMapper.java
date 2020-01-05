package com.brijframework.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.application.beans.EOAppFeatureDTO;
import com.brijframework.application.model.EOAppFeature;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppFeatureMapper extends GenericMapper<EOAppFeature,EOAppFeatureDTO>{

	@Mapping(source="appEditionId", target="appEdition.id")
	@Override
	EOAppFeature mapToDAO(EOAppFeatureDTO eoRoleDTO);
	
	@Mapping(target="appEditionId", source="appEdition.id")
	@Override
    EOAppFeatureDTO mapToDTO(EOAppFeature eoRole);
}
