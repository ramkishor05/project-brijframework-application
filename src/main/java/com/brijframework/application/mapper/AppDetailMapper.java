package com.brijframework.application.mapper;

import org.mapstruct.Mapper;

import com.brijframework.application.beans.EOAppDetailDTO;
import com.brijframework.application.entities.EOAppDetail;

@Mapper(componentModel = "spring", implementationPackage = "com.brijframework.application.mapper.impl")
public interface AppDetailMapper extends GenericMapper<EOAppDetail,EOAppDetailDTO>{

}
