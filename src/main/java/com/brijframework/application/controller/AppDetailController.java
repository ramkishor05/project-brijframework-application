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

import com.brijframework.application.beans.EOAppDetailDTO;
import com.brijframework.application.mapper.AppDetailMapper;
import com.brijframework.application.model.EOAppDetail;
import com.brijframework.application.repository.AppDetailRepository;

@RestController
@RequestMapping("/application/detail")
public class AppDetailController {

	@Autowired
	private AppDetailRepository appDetailRepository;
	
	@Autowired
	private AppDetailMapper appDetailMapper;
	
	@GetMapping
	public List<EOAppDetailDTO> listAppDetail() {
		return appDetailMapper.mapToDTO(appDetailRepository.findAll());
	}
	
	@GetMapping("/{appDetailDTO}")
	public EOAppDetailDTO getAppDetail(@PathVariable Long appDetailDTO) {
		return appDetailMapper.mapToDTO(appDetailRepository.findById(Long.valueOf(appDetailDTO)).orElseGet(null));
	}
	
	@PostMapping
	public EOAppDetailDTO addAppDetail(@RequestBody EOAppDetailDTO applicationDTO) {
		EOAppDetail eoAppDetail = appDetailRepository.save(appDetailMapper.mapToDAO(applicationDTO));
		return appDetailMapper.mapToDTO(eoAppDetail);
	}
	
	@PostMapping("/list")
	public List<EOAppDetailDTO> addAppDetailList(@RequestBody List<EOAppDetailDTO> applicationDTOs) {
		List<EOAppDetail> list=new ArrayList<EOAppDetail>();
		for(EOAppDetailDTO applicationDTO:applicationDTOs) {
		  EOAppDetail eoAppDetail = appDetailRepository.save(appDetailMapper.mapToDAO(applicationDTO));
		  list.add(eoAppDetail);
		}
		return appDetailMapper.mapToDTO(list);
	}
	
	@PutMapping
	public EOAppDetailDTO updateAppDetail(@RequestBody EOAppDetailDTO applicationDTO) {
		EOAppDetail eoAppDetail = appDetailRepository.save(appDetailMapper.mapToDAO(applicationDTO));
		return appDetailMapper.mapToDTO(eoAppDetail);
	}
	
	@PutMapping("/list")
	public List<EOAppDetailDTO> updateAppDetailList(@RequestBody List<EOAppDetailDTO> applicationDTOs) {
		List<EOAppDetail> list=new ArrayList<EOAppDetail>();
		for(EOAppDetailDTO applicationDTO:applicationDTOs) {
		  EOAppDetail eoAppDetail = appDetailRepository.save(appDetailMapper.mapToDAO(applicationDTO));
		  list.add(eoAppDetail);
		}
		return appDetailMapper.mapToDTO(list);
	}
	
	@DeleteMapping
	public boolean deleteAppDetail(@RequestBody EOAppDetailDTO applicationDTO) {
		appDetailRepository.delete(appDetailMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@DeleteMapping("/{appDetailDTO}")
	public boolean deleteAppDetail(@PathVariable Long appDetailDTO) {
		appDetailRepository.deleteById(Long.valueOf(appDetailDTO));
		return true;
	}
}
