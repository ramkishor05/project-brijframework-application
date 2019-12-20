package com.brijframework.application.filters;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;

public class PreFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		com.netflix.zuul.context.RequestContext ctx = com.netflix.zuul.context.RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println("Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());
		return null;
	}
}