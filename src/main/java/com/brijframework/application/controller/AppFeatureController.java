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

import com.brijframework.application.beans.EOAppFeatureDTO;
import com.brijframework.application.entities.EOAppFeature;
import com.brijframework.application.mapper.AppFeatureMapper;
import com.brijframework.application.repository.AppFeatureRepository;

@RestController
@RequestMapping("application/feature/")
public class AppFeatureController {

	@Autowired
	private AppFeatureRepository appFeatureRepository;
	
	@Autowired
	private AppFeatureMapper appFeatureMapper;
	
	@GetMapping
	public List<EOAppFeatureDTO> listAppFeature() {
		return appFeatureMapper.mapToDTO(appFeatureRepository.findAll());
	}
	
	@GetMapping("/{appFeatureDTO}")
	public EOAppFeatureDTO getAppFeature(@PathVariable Long appFeatureDTO) {
		return appFeatureMapper.mapToDTO(appFeatureRepository.findById(Long.valueOf(appFeatureDTO)).orElseGet(null));
	}
	
	@PostMapping
	public EOAppFeatureDTO addAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		EOAppFeature eoAppFeature = appFeatureRepository.save(appFeatureMapper.mapToDAO(applicationDTO));
		return appFeatureMapper.mapToDTO(eoAppFeature);
	}
	
	@PostMapping("/list")
	public List<EOAppFeatureDTO> addAppFeatureList(@RequestBody List<EOAppFeatureDTO> applicationDTOs) {
		List<EOAppFeature> list=new ArrayList<EOAppFeature>();
		for(EOAppFeatureDTO applicationDTO:applicationDTOs) {
		  EOAppFeature eoAppFeature = appFeatureRepository.save(appFeatureMapper.mapToDAO(applicationDTO));
		  list.add(eoAppFeature);
		}
		return appFeatureMapper.mapToDTO(list);
	}
	
	@PutMapping
	public EOAppFeatureDTO updateAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		EOAppFeature eoAppFeature = appFeatureRepository.save(appFeatureMapper.mapToDAO(applicationDTO));
		return appFeatureMapper.mapToDTO(eoAppFeature);
	}
	
	@PutMapping("/list")
	public List<EOAppFeatureDTO> updateAppFeatureList(@RequestBody List<EOAppFeatureDTO> applicationDTOs) {
		List<EOAppFeature> list=new ArrayList<EOAppFeature>();
		for(EOAppFeatureDTO applicationDTO:applicationDTOs) {
		  EOAppFeature eoAppFeature = appFeatureRepository.save(appFeatureMapper.mapToDAO(applicationDTO));
		  list.add(eoAppFeature);
		}
		return appFeatureMapper.mapToDTO(list);
	}
	
	@DeleteMapping
	public boolean deleteAppFeature(@RequestBody EOAppFeatureDTO applicationDTO) {
		appFeatureRepository.delete(appFeatureMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@DeleteMapping("/{applicationDTO}")
	public boolean deleteAppFeature(@PathVariable Long applicationDTO) {
		appFeatureRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
