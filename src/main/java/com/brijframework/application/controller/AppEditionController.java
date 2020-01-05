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

import com.brijframework.application.beans.EOAppEditionDTO;
import com.brijframework.application.service.AppEditionService;

@RestController
@RequestMapping("application/edition")
public class AppEditionController {

	@Autowired
	AppEditionService appEditionService;
	
	@GetMapping
	public List<EOAppEditionDTO> getAppEditionList() {
		return appEditionService.getAppEditionList();
	}
	
	@GetMapping("/{appEditionDTO}")
	public EOAppEditionDTO getAppEdition(@PathVariable Long appEditionDTO) {
		return appEditionService.getAppEdition(appEditionDTO);
	}
	
	@PostMapping
	public EOAppEditionDTO addAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		return appEditionService.saveAppEdition(applicationDTO);
	}
	
	@PostMapping("/list")
	public List<EOAppEditionDTO> addAppEditionList(@RequestBody List<EOAppEditionDTO> applicationDTOs) {
		return appEditionService.saveAppEditionList(applicationDTOs);
	}
	
	@PutMapping
	public EOAppEditionDTO updateAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		return appEditionService.saveAppEdition(applicationDTO);
	}
	
	@PutMapping("/list")
	public List<EOAppEditionDTO> updateAppEditionList(@RequestBody List<EOAppEditionDTO> applicationDTOs) {
		return appEditionService.saveAppEditionList(applicationDTOs);
	}
	
	@DeleteMapping
	public boolean deleteAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		return appEditionService.deleteAppEdition(applicationDTO);
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppEdition(@PathVariable Long applicationDTO) {
		return appEditionService.deleteAppEdition(applicationDTO);
	}
}
