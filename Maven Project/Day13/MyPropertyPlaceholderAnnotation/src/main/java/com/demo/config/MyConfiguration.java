package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@PropertySource("data.properties")
public class MyConfiguration {
	@Bean 
	public PropertySourcesPlaceholderConfigurer getPlaceHolder() {
		System.out.println("in getPlaceHolder");
		PropertySourcesPlaceholderConfigurer placeholder=new PropertySourcesPlaceholderConfigurer();
		return placeholder;
	}
	

}
