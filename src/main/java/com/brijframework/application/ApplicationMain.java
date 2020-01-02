package com.brijframework.application;

import org.brijframework.bean.context.BeanContext;
import org.brijframework.boot.runner.ApplicationContextRunner;
import org.brijframework.context.bootstrap.BootstrapContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.brijframework.application.model.EOLKCountFreq;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableZuulProxy
public class ApplicationMain 
{
    public static void main( String[] args )
    {
    	//SpringApplication.run(ApplicationMain.class, args);
    	
    	BootstrapContext applicationContext = ApplicationContextRunner.run(args).getApplicationContext();
		BeanContext beanContext= (BeanContext) applicationContext.getModuleContext(BeanContext.class);
		
		System.out.println(beanContext.getBeanList(EOLKCountFreq.class));
    }
}
