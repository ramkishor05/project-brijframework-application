package com.brijframework.application;

import java.util.List;

import org.brijframework.bean.context.BeanContext;
import org.brijframework.boot.runner.ApplicationContextRunner;
import org.brijframework.context.bootstrap.BootstrapContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.application.model.EOLKCountFreq;
import com.brijframework.application.model.EOLKUnit;
import com.brijframework.application.model.EOLKUnitConversion;
import com.brijframework.application.model.EOLKUnitGroup;
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