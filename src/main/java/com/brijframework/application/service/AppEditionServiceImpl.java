package com.brijframework.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.brijframework.application.beans.EOAppEditionDTO;
import com.brijframework.application.mapper.AppEditionMapper;
import com.brijframework.application.repository.AppEditionRepository;

@Service
public class AppEditionServiceImpl implements AppEditionService{
	@Autowired
	private AppEditionMapper appEditionMapper;
	
	@Autowired
	private AppEditionRepository appEditionRepository;

	@Override
	public EOAppEditionDTO saveAppEdition(EOAppEditionDTO applicationDTO) {
		return appEditionMapper.mapToDTO(appEditionRepository.save(appEditionMapper.mapToDAO(applicationDTO)));
	}
	
	@Override
	public List<EOAppEditionDTO> saveAppEditionList(@RequestBody List<EOAppEditionDTO> applicationDTOs) {
		List<EOAppEditionDTO> list=new ArrayList<EOAppEditionDTO>();
		for(EOAppEditionDTO applicationDTO:applicationDTOs) {
		  list.add(saveAppEdition(applicationDTO));
		}
		return list;
	}

	@Override
	public List<EOAppEditionDTO> getAppEditionList() {
		return appEditionMapper.mapToDTO(appEditionRepository.findAll());
	}
	
	@Override
	public EOAppEditionDTO getAppEdition(Long appEditionDTO) {
		return appEditionMapper.mapToDTO(appEditionRepository.findById(Long.valueOf(appEditionDTO)).orElseGet(null));
	}
	
	@Override
	public boolean deleteAppEdition(EOAppEditionDTO applicationDTO) {
		appEditionRepository.delete(appEditionMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@Override
	public boolean deleteAppEdition(Long applicationDTO) {
		appEditionRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
