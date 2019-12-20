package com.brijframework.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brijframework.application.filters.ErrorFilter;
import com.brijframework.application.filters.PostFilter;
import com.brijframework.application.filters.PreFilter;
import com.brijframework.application.filters.RouteFilter;

@Configuration
public class GatwayConfig {

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
