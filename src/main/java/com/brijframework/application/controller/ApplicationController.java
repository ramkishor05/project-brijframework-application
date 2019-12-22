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

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.entities.EOApplication;
import com.brijframework.application.mapper.ApplicationMapper;
import com.brijframework.application.repository.ApplicationRepository;

@RestController()
@RequestMapping("application/")
public class ApplicationController {

	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@GetMapping
	public List<EOApplicationDTO> listApplication() {
		return applicationMapper.mapToDTO(applicationRepository.findAll());
	}
	
	@GetMapping("/{applicationId}")
	public EOApplicationDTO getApplication(@PathVariable Long applicationId) {
		return applicationMapper.mapToDTO(applicationRepository.findById(Long.valueOf(applicationId)).orElseGet(null));
	}
	
	@PostMapping
	public EOApplicationDTO addApplication(@RequestBody EOApplicationDTO applicationDTO) {
		EOApplication eoApplication = applicationRepository.save(applicationMapper.mapToDAO(applicationDTO));
		return applicationMapper.mapToDTO(eoApplication);
	}
	
	@PostMapping("/list")
	public List<EOApplicationDTO> addApplicationList(@RequestBody List<EOApplicationDTO> applicationDTOs) {
		List<EOApplication> list=new ArrayList<EOApplication>();
		for(EOApplicationDTO applicationDTO:applicationDTOs) {
		  EOApplication eoApplication = applicationRepository.save(applicationMapper.mapToDAO(applicationDTO));
		  list.add(eoApplication);
		}
		return applicationMapper.mapToDTO(list);
	}
	
	@PutMapping
	public EOApplicationDTO updateApplication(@RequestBody EOApplicationDTO applicationDTO) {
		EOApplication eoApplication = applicationRepository.save(applicationMapper.mapToDAO(applicationDTO));
		return applicationMapper.mapToDTO(eoApplication);
	}
	
	@PutMapping("/list")
	public List<EOApplicationDTO> updateApplicationList(@RequestBody List<EOApplicationDTO> applicationDTOs) {
		List<EOApplication> list=new ArrayList<EOApplication>();
		for(EOApplicationDTO applicationDTO:applicationDTOs) {
		  EOApplication eoApplication = applicationRepository.save(applicationMapper.mapToDAO(applicationDTO));
		  list.add(eoApplication);
		}
		return applicationMapper.mapToDTO(list);
	}
	
	
	@DeleteMapping("/{applicationId}")
	public boolean deleteApplication(@PathVariable Long applicationId) {
		applicationRepository.deleteById(Long.valueOf(applicationId));
		return true;
	}
}
