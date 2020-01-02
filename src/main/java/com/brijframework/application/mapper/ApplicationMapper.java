package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.model.EOApplication;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface ApplicationMapper extends GenericMapper<EOApplication,EOApplicationDTO>{

}
