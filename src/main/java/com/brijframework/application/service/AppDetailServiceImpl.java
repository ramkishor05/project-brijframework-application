package com.brijframework.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.mapper.ApplicationMapper;
import com.brijframework.application.model.EOApplication;
import com.brijframework.application.repository.AppDetailRepository;
import com.brijframework.application.repository.ApplicationRepository;

@Service
public class AppDetailServiceImpl implements AppDetailService{
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private AppDetailRepository appDetailRepository;
	
	@Override
	public EOApplicationDTO saveApplication(EOApplicationDTO applicationDTO) {
		EOApplication eoApplicationDTO = applicationMapper.mapToDAO(applicationDTO);
		if(eoApplicationDTO.getAppDetail()!=null ) {
			appDetailRepository.save(eoApplicationDTO.getAppDetail());
		}
		EOApplication eoApplication = applicationRepository.save(eoApplicationDTO);
		return applicationMapper.mapToDTO(eoApplication);
	}
	
	@Override
	public List<EOApplicationDTO> saveApplicationList(List<EOApplicationDTO> applicationDTOs) {
		List<EOApplicationDTO> list=new ArrayList<EOApplicationDTO>();
		for(EOApplicationDTO applicationDTO:applicationDTOs) {
		   list.add(this.saveApplication(applicationDTO));
		}
		return list;
	}
	
	@Override
	public List<EOApplicationDTO> getApplicationList() {
		return applicationMapper.mapToDTO(applicationRepository.findAll());
	}
	
	@Override
	public EOApplicationDTO getApplication(Long applicationId) {
		return applicationMapper.mapToDTO(applicationRepository.findById(Long.valueOf(applicationId)).orElseGet(null));
	}
	
	@Override
	public boolean deleteApplication(Long applicationId) {
		applicationRepository.deleteById(Long.valueOf(applicationId));
		return true;
	}

}
