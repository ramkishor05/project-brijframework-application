package com.brijframework.application;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	
    }
}