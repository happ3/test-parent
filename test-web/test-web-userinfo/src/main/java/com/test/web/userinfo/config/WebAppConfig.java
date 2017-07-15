package com.test.web.userinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.test.web.userinfo.config.interceptor.WebAppInterceptor;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new WebAppInterceptor()).addPathPatterns("/**");
	}

}
