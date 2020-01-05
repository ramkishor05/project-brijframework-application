package com.brijframework.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.application.beans.EOAppRoleDTO;
import com.brijframework.application.mapper.AppRoleMapper;
import com.brijframework.application.model.EOAppRole;
import com.brijframework.application.repository.AppRoleRepository;

@Service
public class AppRoleServiceImpl implements AppRoleService {

	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppRoleMapper appRoleMapper;
	
	@Override
	public List<EOAppRoleDTO> getAppRoleList() {
		return appRoleMapper.mapToDTO(appRoleRepository.findAll());
	}
	
	@Override
	public EOAppRoleDTO getAppRole(Long appRoleDTO) {
		return appRoleMapper.mapToDTO(appRoleRepository.findById(Long.valueOf(appRoleDTO)).orElseGet(null));
	}
	
	@Override
	public EOAppRoleDTO saveAppRole(EOAppRoleDTO applicationDTO) {
		EOAppRole eoAppRole = appRoleRepository.save(appRoleMapper.mapToDAO(applicationDTO));
		return appRoleMapper.mapToDTO(eoAppRole);
	}
	
	@Override
	public List<EOAppRoleDTO> saveAppRoleList(List<EOAppRoleDTO> applicationDTOs) {
		List<EOAppRoleDTO> list=new ArrayList<EOAppRoleDTO>();
		for(EOAppRoleDTO applicationDTO:applicationDTOs) {
		  list.add(saveAppRole(applicationDTO));
		}
		return list;
	}
	
	@Override
	public boolean deleteAppRole(EOAppRoleDTO applicationDTO) {
		appRoleRepository.delete(appRoleMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@Override
	public boolean deleteAppRole(Long applicationDTO) {
		appRoleRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
