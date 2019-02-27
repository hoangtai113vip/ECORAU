package com.example.interceptor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.interceptor.UserInterceptor;





@Configuration

public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	UserInterceptor userInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userInterceptor);
	}

	
}
