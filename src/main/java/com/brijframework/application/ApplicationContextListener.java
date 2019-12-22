package com.brijframework.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.application.repository.AppRoleRepository;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AppRoleRepository appRoleRepository;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	
    }
}