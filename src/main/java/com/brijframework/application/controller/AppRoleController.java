package com.brijframework.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.application.beans.EOAppRoleDTO;
import com.brijframework.application.entities.EOAppRole;
import com.brijframework.application.mapper.AppRoleMapper;
import com.brijframework.application.repository.AppRoleRepository;

@RestController
@RequestMapping("application/role/")
public class AppRoleController {

	@Autowired
	private AppRoleRepository appRoleRepository;
	
	@Autowired
	private AppRoleMapper appRoleMapper;
	
	@GetMapping
	public List<EOAppRoleDTO> listAppRole() {
		return appRoleMapper.mapToDTO(appRoleRepository.findAll());
	}
	
	@GetMapping("/{appRoleDTO}")
	public EOAppRoleDTO getAppRole(@PathVariable Long appRoleDTO) {
		return appRoleMapper.mapToDTO(appRoleRepository.findById(Long.valueOf(appRoleDTO)).orElseGet(null));
	}
	
	@PostMapping
	public EOAppRoleDTO addAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		EOAppRole eoAppRole = appRoleRepository.save(appRoleMapper.mapToDAO(applicationDTO));
		return appRoleMapper.mapToDTO(eoAppRole);
	}
	
	@PostMapping("/list")
	public List<EOAppRoleDTO> addAppRoleList(@RequestBody List<EOAppRoleDTO> applicationDTOs) {
		List<EOAppRole> list=new ArrayList<EOAppRole>();
		for(EOAppRoleDTO applicationDTO:applicationDTOs) {
		  EOAppRole eoAppRole = appRoleRepository.save(appRoleMapper.mapToDAO(applicationDTO));
		  list.add(eoAppRole);
		}
		return appRoleMapper.mapToDTO(list);
	}
	
	@PutMapping
	public EOAppRoleDTO updateAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		EOAppRole eoAppRole = appRoleRepository.save(appRoleMapper.mapToDAO(applicationDTO));
		return appRoleMapper.mapToDTO(eoAppRole);
	}
	
	@PutMapping("/list")
	public List<EOAppRoleDTO> updateAppRoleList(@RequestBody List<EOAppRoleDTO> applicationDTOs) {
		List<EOAppRole> list=new ArrayList<EOAppRole>();
		for(EOAppRoleDTO applicationDTO:applicationDTOs) {
		  EOAppRole eoAppRole = appRoleRepository.save(appRoleMapper.mapToDAO(applicationDTO));
		  list.add(eoAppRole);
		}
		return appRoleMapper.mapToDTO(list);
	}
	
	@DeleteMapping
	public boolean deleteAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		appRoleRepository.delete(appRoleMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppRole(@PathVariable Long applicationDTO) {
		appRoleRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
