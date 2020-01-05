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

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.service.AppDetailService;

@RestController()
@RequestMapping("application")
public class ApplicationController {

	@Autowired
	private AppDetailService applicationService;
	
	@GetMapping
	public List<EOApplicationDTO> getApplicationList() {
		return applicationService.getApplicationList();
	}
	
	@GetMapping("/{applicationId}")
	public EOApplicationDTO getApplication(@PathVariable Long applicationId) {
		return applicationService.getApplication(applicationId);
	}
	
	@PostMapping
	public EOApplicationDTO addApplication(@RequestBody EOApplicationDTO applicationDTO) {
		return applicationService.saveApplication(applicationDTO);
	}
	
	@PostMapping("/list")
	public List<EOApplicationDTO> addApplicationList(@RequestBody List<EOApplicationDTO> applicationDTOs) {
		return applicationService.saveApplicationList(applicationDTOs);
	}
	
	@PutMapping
	public EOApplicationDTO updateApplication(@RequestBody EOApplicationDTO applicationDTO) {
		return applicationService.saveApplication(applicationDTO);
	}
	
	@PutMapping("/list")
	public List<EOApplicationDTO> updateApplicationList(@RequestBody List<EOApplicationDTO> applicationDTOs) {
		return applicationService.saveApplicationList(applicationDTOs);
	}
	
	@DeleteMapping("/{applicationId}")
	public boolean deleteApplication(@PathVariable Long applicationId) {
		return applicationService.deleteApplication(applicationId);
	}
}
