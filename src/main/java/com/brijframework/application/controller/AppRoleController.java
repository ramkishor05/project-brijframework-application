package com.brijframework.application.controller;

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
import com.brijframework.application.service.AppRoleService;

@RestController
@RequestMapping("application/role")
public class AppRoleController {

	@Autowired
	private AppRoleService appRoleService;
	
	@GetMapping
	public List<EOAppRoleDTO> getAppRoleList() {
		return appRoleService.getAppRoleList();
	}
	
	@GetMapping("/{appRoleDTO}")
	public EOAppRoleDTO getAppRole(@PathVariable Long appRoleDTO) {
		return appRoleService.getAppRole(appRoleDTO);
	}
	
	@PostMapping
	public EOAppRoleDTO addAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		return appRoleService.saveAppRole(applicationDTO);
	}
	
	@PostMapping("/list")
	public List<EOAppRoleDTO> addAppRoleList(@RequestBody List<EOAppRoleDTO> applicationDTOs) {
		return appRoleService.saveAppRoleList(applicationDTOs);
	}
	
	@PutMapping
	public EOAppRoleDTO updateAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		return appRoleService.saveAppRole(applicationDTO);
	}
	
	@PutMapping("/list")
	public List<EOAppRoleDTO> updateAppRoleList(@RequestBody List<EOAppRoleDTO> applicationDTOs) {
		return appRoleService.saveAppRoleList(applicationDTOs);
	}
	
	@DeleteMapping
	public boolean deleteAppRole(@RequestBody EOAppRoleDTO applicationDTO) {
		return appRoleService.deleteAppRole(applicationDTO);
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppRole(@PathVariable Long applicationDTO) {
		return appRoleService.deleteAppRole(applicationDTO);
	}
}
