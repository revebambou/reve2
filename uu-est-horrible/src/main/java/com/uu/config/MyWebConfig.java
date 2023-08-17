package com.uu.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author uuEstHorrible
 *
 */
public class MyWebConfig implements WebMvcConfigurer {
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
	        "classpath:/META-INF/resources/", "classpath:/resources/",
	        "classpath:/static/", "classpath:/public/" };
	
	public void addResourceHandler(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app/resource/**").addResourceLocations("file:D:/computer_pic/");
	}
}
