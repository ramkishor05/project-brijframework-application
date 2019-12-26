package com.brijframework.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.application.beans.EOApplicationDTO;
import com.brijframework.application.entities.EOApplication;
import com.brijframework.application.mapper.ApplicationMapper;
import com.brijframework.application.repository.AppDetailRepository;
import com.brijframework.application.repository.AppEditionRepository;
import com.brijframework.application.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private ApplicationMapper applicationMapper;
	
	@Autowired
	private AppDetailRepository appDetailRepository;
	
	@Autowired
	private AppEditionRepository appEditionRepository;
	
	@Override
	public EOApplicationDTO saveApplication(EOApplicationDTO applicationDTO) {
		EOApplication eoApplicationDTO = applicationMapper.mapToDAO(applicationDTO);
		if(eoApplicationDTO.getAppDetail()!=null ) {
			appDetailRepository.save(eoApplicationDTO.getAppDetail());
		}
		if(eoApplicationDTO.getAppEdition()!=null ) {
			appEditionRepository.save(eoApplicationDTO.getAppEdition());
		}
		EOApplication eoApplication = applicationRepository.save(eoApplicationDTO);
		return applicationMapper.mapToDTO(eoApplication);
	}

}
