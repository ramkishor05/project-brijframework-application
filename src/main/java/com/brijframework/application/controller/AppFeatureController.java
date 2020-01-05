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

import com.brijframework.application.beans.EOAppFeatureDTO;
import com.brijframework.application.service.AppFeatureService;

@RestController
@RequestMapping("application/feature")
public class AppFeatureController {

	@Autowired
	private AppFeatureService appFeatureService;
	
	@GetMapping
	public List<EOAppFeatureDTO> getAppFeatureList() {
		return appFeatureService.getAppFeatureList();
	}
	
	@GetMapping("/{appFeatureDTO}")
	public EOAppFeatureDTO getAppFeature(@PathVariable Long appFeatureDTO) {
		return appFeatureService.getAppFeature(appFeatureDTO);
	}
	
	@PostMapping
	public EOAppFeatureDTO addAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		return appFeatureService.saveAppFeature(applicationDTO);
	}
	
	@PostMapping("/list")
	public List<EOAppFeatureDTO> addAppFeatureList(@RequestBody List<EOAppFeatureDTO> applicationDTOs) {
		return appFeatureService.saveAppFeatureList(applicationDTOs);
	}
	
	@PutMapping
	public EOAppFeatureDTO updateAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		return appFeatureService.saveAppFeature(applicationDTO);
	}
	
	@PutMapping("/list")
	public List<EOAppFeatureDTO> updateAppFeatureList(@RequestBody List<EOAppFeatureDTO> applicationDTOs) {
		return appFeatureService.saveAppFeatureList(applicationDTOs);
	}
	
	@DeleteMapping
	public boolean deleteAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		return appFeatureService.deleteAppFeature(applicationDTO);
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppFeature(@PathVariable Long applicationDTO) {
		return appFeatureService.deleteAppFeature(applicationDTO);
	}
}
