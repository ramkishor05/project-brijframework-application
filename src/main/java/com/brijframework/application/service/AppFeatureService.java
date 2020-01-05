package com.brijframework.application.service;

import java.util.List;

import com.brijframework.application.beans.EOAppFeatureDTO;

public interface AppFeatureService {

	List<EOAppFeatureDTO> getAppFeatureList();

	EOAppFeatureDTO getAppFeature(Long appFeatureDTO);

	EOAppFeatureDTO saveAppFeature(EOAppFeatureDTO applicationDTO);

	List<EOAppFeatureDTO> saveAppFeatureList(List<EOAppFeatureDTO> applicationDTOs);

	boolean deleteAppFeature(EOAppFeatureDTO applicationDTO);

	boolean deleteAppFeature(Long applicationDTO);

}
