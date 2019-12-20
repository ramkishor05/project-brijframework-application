package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOAppEditionDTO;
import com.brijframework.application.entities.EOAppEdition;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppEditionMapper extends GenericMapper<EOAppEdition,EOAppEditionDTO>{

}
