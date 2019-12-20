package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.entities.EOApplication;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface ApplicationMapper extends GenericMapper<EOApplication,EOApplicationDTO>{

}
