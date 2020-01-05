package com.brijframework.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.application.beans.EOAppFeatureDTO;
import com.brijframework.application.mapper.AppFeatureMapper;
import com.brijframework.application.model.EOAppFeature;
import com.brijframework.application.repository.AppFeatureRepository;

@Service
public class AppFeatureServiceImpl implements AppFeatureService {

	@Autowired
	private AppFeatureRepository appFeatureRepository;
	
	@Autowired
	private AppFeatureMapper appFeatureMapper;
	
	@Override
	public List<EOAppFeatureDTO> getAppFeatureList() {
		return appFeatureMapper.mapToDTO(appFeatureRepository.findAll());
	}
	
	@Override
	public EOAppFeatureDTO getAppFeature(Long appFeatureDTO) {
		return appFeatureMapper.mapToDTO(appFeatureRepository.findById(Long.valueOf(appFeatureDTO)).orElseGet(null));
	}
	
	@Override
	public EOAppFeatureDTO saveAppFeature(EOAppFeatureDTO applicationDTO) {
		EOAppFeature eoAppFeature = appFeatureRepository.save(appFeatureMapper.mapToDAO(applicationDTO));
		return appFeatureMapper.mapToDTO(eoAppFeature);
	}
	
	@Override
	public List<EOAppFeatureDTO> saveAppFeatureList(List<EOAppFeatureDTO> applicationDTOs) {
		List<EOAppFeatureDTO> list=new ArrayList<EOAppFeatureDTO>();
		for(EOAppFeatureDTO applicationDTO:applicationDTOs) {
		  list.add(saveAppFeature(applicationDTO));
		}
		return list;
	}
	
	@Override
	public boolean deleteAppFeature(EOAppFeatureDTO applicationDTO) {
		appFeatureRepository.delete(appFeatureMapper.mapToDAO(applicationDTO));
		return true;
	}
	
	@Override
	public boolean deleteAppFeature(Long applicationDTO) {
		appFeatureRepository.deleteById(Long.valueOf(applicationDTO));
		return true;
	}
}
