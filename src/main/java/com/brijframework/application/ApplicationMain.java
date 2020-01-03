package com.brijframework.application;

import org.brijframework.bean.context.BeanContext;
import org.brijframework.boot.runner.ApplicationContextRunner;
import org.brijframework.context.bootstrap.BootstrapContext;
import org.brijframework.support.app.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import com.brijframework.application.model.EOLKUnit;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@EnableZuulProxy
@ApplicationRunner
public class ApplicationMain 
{
    public static void main( String[] args )
    {
         SpringApplication.run(ApplicationMain.class, args);
    	
    	/*BootstrapContext applicationContext = ApplicationContextRunner.run(args).getApplicationContext();
		BeanContext beanContext= (BeanContext) applicationContext.getModuleContext(BeanContext.class);
		
		System.out.println(beanContext.getBeanList(EOLKUnit.class));*/
    }
}
