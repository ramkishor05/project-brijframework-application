package com.brijframework.application;

import java.util.List;

import org.brijframework.bean.context.BeanContext;
import org.brijframework.boot.runner.ApplicationContextRunner;
import org.brijframework.context.bootstrap.BootstrapContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.application.model.EOAppDetail;
import com.brijframework.application.model.EOAppEdition;
import com.brijframework.application.model.EOAppFeature;
import com.brijframework.application.model.EOAppRole;
import com.brijframework.application.model.EOApplication;
import com.brijframework.application.model.EOLKCountFreq;
import com.brijframework.application.model.EOLKUnit;
import com.brijframework.application.model.EOLKUnitConversion;
import com.brijframework.application.model.EOLKUnitGroup;
import com.brijframework.application.repository.AppDetailRepository;
import com.brijframework.application.repository.AppEditionRepository;
import com.brijframework.application.repository.AppFeatureRepository;
import com.brijframework.application.repository.AppRoleRepository;
import com.brijframework.application.repository.ApplicationRepository;
import com.brijframework.application.repository.LKCountFreqRepository;
import com.brijframework.application.repository.LKUnitConversionRepository;
import com.brijframework.application.repository.LKUnitGroupRepository;
import com.brijframework.application.repository.LKUnitRepository;

@Component
public class ApplicationMainListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	AppFeatureRepository appFeatureRepository;
	
	@Autowired
	AppEditionRepository appEditionRepository;
	
	@Autowired
	AppDetailRepository appDetailRepository;
	
	@Autowired
	AppRoleRepository appRoleRepository;

	@Autowired
	LKCountFreqRepository lkCountFreqRepository;

	@Autowired
	LKUnitGroupRepository lkUnitGroupRepository;

	@Autowired
	LKUnitRepository lkUnitRepository;

	@Autowired
	LKUnitConversionRepository lkUnitConversionRepository;

	@SuppressWarnings("unchecked")
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		BootstrapContext applicationContext = ApplicationContextRunner.run().getApplicationContext();
		BeanContext beanContext = (BeanContext) applicationContext.getModuleContext(BeanContext.class);

		List<EOAppDetail> eoAppDetails = (List<EOAppDetail>) beanContext.getBeanList(EOAppDetail.class);
		System.out.println("eoAppDetails=="+eoAppDetails);
		for (EOAppDetail eoAppDetail : eoAppDetails) {
			appDetailRepository.save(eoAppDetail);
		}

		List<EOApplication> eoApplications = (List<EOApplication>) beanContext.getBeanList(EOApplication.class);
		System.out.println("eoApplications=="+eoApplications);
		for (EOApplication eoApplication : eoApplications) {
			applicationRepository.save(eoApplication);
		}
		
		List<EOAppEdition> eoAppEditions = (List<EOAppEdition>) beanContext.getBeanList(EOAppEdition.class);
		System.out.println("eoAppEditions=="+eoAppEditions);
		for (EOAppEdition eoAppEdition : eoAppEditions) {
			appEditionRepository.save(eoAppEdition);
		}
		
		List<EOAppFeature> eoAppFeatures = (List<EOAppFeature>) beanContext.getBeanList(EOAppFeature.class);
		System.out.println("eoAppFeatures=="+eoAppFeatures);
		for (EOAppFeature eoAppFeature : eoAppFeatures) {
			appFeatureRepository.save(eoAppFeature);
		}

		List<EOAppRole> eoAppRoles = (List<EOAppRole>) beanContext.getBeanList(EOAppRole.class);
		System.out.println("eoAppRoles=="+eoAppRoles);
		for (EOAppRole eoAppRole : eoAppRoles) {
			appRoleRepository.save(eoAppRole);
		}
		
		List<EOLKCountFreq> eolkCountFreqs = (List<EOLKCountFreq>) beanContext.getBeanList(EOLKCountFreq.class);
		System.out.println("eolkCountFreqs=="+eolkCountFreqs);
		for (EOLKCountFreq eolkCountFreq : eolkCountFreqs) {
			lkCountFreqRepository.save(eolkCountFreq);
		}

		List<EOLKUnitGroup> eolkUnitGroups = (List<EOLKUnitGroup>) beanContext.getBeanList(EOLKUnitGroup.class);
		System.out.println("eolkUnitGroups=="+eolkUnitGroups);
		for (EOLKUnitGroup eolkUnitGroup : eolkUnitGroups) {
			lkUnitGroupRepository.save(eolkUnitGroup);
		}

		List<EOLKUnit> eolkUnits = (List<EOLKUnit>) beanContext.getBeanList(EOLKUnit.class);
		System.out.println("eolkUnits=="+eolkUnits);
		for (EOLKUnit eolkUnit : eolkUnits) {
			lkUnitRepository.save(eolkUnit);
		}
		
		List<EOLKUnitConversion> eolkUnitConversions = (List<EOLKUnitConversion>) beanContext.getBeanList(EOLKUnitConversion.class);
		System.out.println("eolkUnitConversions=="+eolkUnitConversions);
		for (EOLKUnitConversion eolkUnitConversion : eolkUnitConversions) {
			lkUnitConversionRepository.save(eolkUnitConversion);
		}
	}
}