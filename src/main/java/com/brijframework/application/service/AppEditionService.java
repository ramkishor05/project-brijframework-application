package com.brijframework.application.service;

import java.util.List;

import com.brijframework.application.beans.EOAppEditionDTO;

public interface AppEditionService {

	EOAppEditionDTO saveAppEdition(EOAppEditionDTO applicationDTO);

	List<EOAppEditionDTO> saveAppEditionList(List<EOAppEditionDTO> applicationDTOs);

	List<EOAppEditionDTO> getAppEditionList();

	EOAppEditionDTO getAppEdition(Long appEditionDTO);

	boolean deleteAppEdition(EOAppEditionDTO applicationDTO);

	boolean deleteAppEdition(Long applicationDTO);

}
