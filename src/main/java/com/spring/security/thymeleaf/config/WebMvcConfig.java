package com.spring.security.thymeleaf.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.resource.ResourceUrlProviderExposingInterceptor;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


public class WebMvcConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new ThymeleafLayoutInterceptor());
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/**")
		.addResourceLocations("src/main/resources/static");
	}
	
//	@Bean
//    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
//        
//		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//        Map<String, Object> map = new LinkedHashMap<>();
//        ResourceHttpRequestHandler resourceHttpRequestHandler = new ResourceHttpRequestHandler();
//        
//        List<Resource> locations = new ArrayList<>();
//        locations.add(new ServletContextResource(getServletContext(), "/"));
//        locations.add(new ClassPathResource("META-INF/resources"));
//        locations.add(new ClassPathResource("resources/"));
//        locations.add(new ClassPathResource("static/"));
//        locations.add(new ClassPathResource("public/"));
//        
//        resourceHttpRequestHandler.setLocations(locations);
//        resourceHttpRequestHandler.setApplicationContext(getApplicationContext());
//
//        List<ResourceResolver> resourceResolvers = new ArrayList<>();
//        
//        PathResourceResolver resourceResolver = new PathResourceResolver();
//        resourceResolver.setAllowedLocations(new ServletContextResource(getServletContext(), "/"), new ClassPathResource("META-INF/resources"), new ClassPathResource("resources/"), new ClassPathResource("static/"), new ClassPathResource("public/"));
//        resourceResolvers.add(resourceResolver);
//
//        resourceHttpRequestHandler.setResourceResolvers(resourceResolvers);
//        map.put("/**", resourceHttpRequestHandler);
//        simpleUrlHandlerMapping.setUrlMap(map);
//        ResourceUrlProvider resourceUrlProvider = new ResourceUrlProvider();
//        Map<String, ResourceHttpRequestHandler> handlerMap = new LinkedHashMap<>();
//        handlerMap.put("/**", resourceHttpRequestHandler);
//        resourceUrlProvider.setHandlerMap(handlerMap);
//        ResourceUrlProviderExposingInterceptor interceptor = new ResourceUrlProviderExposingInterceptor(resourceUrlProvider);
//        simpleUrlHandlerMapping.setInterceptors(new Object[]{interceptor});
//        return simpleUrlHandlerMapping;
//    }
	

}
