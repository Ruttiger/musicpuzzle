//package com.fs.iniciativainnovacion.musicpuzzle;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableConfigurationProperties({ ResourceProperties.class })
//public class StaticResourcesConfiguration extends WebMvcConfigurerAdapter {
//
//    static final String[] STATIC_RESOURCES = new String[] {
//            "/**/*.mp3"
//    };
//
//    @Autowired
//    private ResourceProperties resourceProperties = new ResourceProperties();
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(STATIC_RESOURCES).addResourceLocations(resourceProperties.getStaticLocations());
//    }
//}
