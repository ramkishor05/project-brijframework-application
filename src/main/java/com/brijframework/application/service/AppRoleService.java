package com.brijframework.application.service;

import java.util.List;

import com.brijframework.application.beans.EOAppRoleDTO;

public interface AppRoleService {

	boolean deleteAppRole(Long applicationDTO);

	boolean deleteAppRole(EOAppRoleDTO applicationDTO);

	List<EOAppRoleDTO> saveAppRoleList(List<EOAppRoleDTO> applicationDTOs);

	EOAppRoleDTO saveAppRole(EOAppRoleDTO applicationDTO);

	EOAppRoleDTO getAppRole(Long appRoleDTO);

	List<EOAppRoleDTO> getAppRoleList();

}
