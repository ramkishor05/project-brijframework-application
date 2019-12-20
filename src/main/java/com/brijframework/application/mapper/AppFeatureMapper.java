package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOAppFeatureDTO;
import com.brijframework.application.entities.EOAppFeature;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppFeatureMapper extends GenericMapper<EOAppFeature,EOAppFeatureDTO>{

}
