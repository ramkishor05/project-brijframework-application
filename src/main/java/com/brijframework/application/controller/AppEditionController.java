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

import com.brijframework.application.beans.EOAppEditionDTO;
import com.brijframework.application.entities.EOAppEdition;
import com.brijframework.application.mapper.AppEditionMapper;
import com.brijframework.application.repository.AppEditionRepository;

@RestController
@RequestMapping("application/edition/")
public class AppEditionController {

	@Autowired
	private AppEditionRepository appEditionRepository;
	
	@Autowired
	private AppEditionMapper appEditionMapper;
	
	@GetMapping
	public List<EOAppEditionDTO> listAppEdition() {
		return appEditionMapper.mapToDTO(appEditionRepository.findAll());
	}
	
	@GetMapping("/{appEditionDTO}")
	public EOAppEditionDTO getAppEdition(@PathVariable Long appEditionDTO) {
		return appEditionMapper.mapToDTO(appEditionRepository.findById(Long.valueOf(appEditionDTO)).orElseGet(null));
	}
	
	@PostMapping
	public EOAppEditionDTO addAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		EOAppEdition eoAppEdition = appEditionRepository.save(appEditionMapper.mapToDAO(applicationDTO));
		return appEditionMapper.mapToDTO(eoAppEdition);
	}
	
	@PostMapping("/list")
	public List<EOAppEditionDTO> addAppEditionList(@RequestBody List<EOAppEditionDTO> applicationDTOs) {
		List<EOAppEdition> list=new ArrayList<EOAppEdition>();
		for(EOAppEditionDTO applicationDTO:applicationDTOs) {
		  EOAppEdition eoAppEdition = appEditionRepository.save(appEditionMapper.mapToDAO(applicationDTO));
		  list.add(eoAppEdition);
		}
		return appEditionMapper.mapToDTO(list);
	}
	
	@PutMapping
	public EOAppEditionDTO updateAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		EOAppEdition eoAppEdition = appEditionRepository.save(appEditionMapper.mapToDAO(applicationDTO));
		return appEditionMapper.mapToDTO(eoAppEdition);
	}
	
	@PutMapping("/list")
	public List<EOAppEditionDTO> updateAppEditionList(@RequestBody List<EOAppEditionDTO> applicationDTOs) {
		List<EOAppEdition> list=new ArrayList<EOAppEdition>();
		for(EOAppEditionDTO applicationDTO:applicationDTOs) {
		  EOAppEdition eoAppEdition = appEditionRepository.save(appEditionMapper.mapToDAO(applicationDTO));
		  list.add(eoAppEdition);
		}
		return appEditionMapper.mapToDTO(list);
	}
	
	@DeleteMapping
	public boolean deleteAppEdition(@RequestBody EOAppEditionDTO applicationDTO) {
		appEditionRepository.delete(appEditionMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppEdition(@PathVariable Long applicationDTO) {
		appEditionRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
