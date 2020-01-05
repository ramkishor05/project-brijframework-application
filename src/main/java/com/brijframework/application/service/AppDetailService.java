package com.brijframework.application.service;

import java.util.List;

import com.brijframework.application.beans.EOApplicationDTO;

public interface AppDetailService {

	EOApplicationDTO saveApplication(EOApplicationDTO applicationDTO);

	List<EOApplicationDTO> saveApplicationList(List<EOApplicationDTO> applicationDTOs);
	
	List<EOApplicationDTO> getApplicationList();

	EOApplicationDTO getApplication(Long applicationId);

	boolean deleteApplication(Long applicationId);

}
