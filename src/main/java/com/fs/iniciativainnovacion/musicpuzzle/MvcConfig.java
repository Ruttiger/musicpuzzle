package com.fs.iniciativainnovacion.musicpuzzle;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/puzzle").setViewName("puzzle");
        registry.addViewController("/yetanotherpuzzle").setViewName("yetanotherpuzzle");
        registry.addViewController("/isthislastpuzzle").setViewName("isthislastpuzzle");
        registry.addViewController("/puzzle1success").setViewName("puzzle1success");
        registry.addViewController("/puzzle2success").setViewName("puzzle2success");
        registry.addViewController("/puzzle3success").setViewName("puzzle3success");
        registry.addViewController("/puzzlenacho1").setViewName("puzzlenacho1");
        registry.addViewController("/puzzlenacho2").setViewName("puzzlenacho2");
        registry.addViewController("/puzzlenacho3").setViewName("puzzlenacho3");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/audio/**",
                "/pictures/**")
                .addResourceLocations(
                        "classpath:/audio/",
                        "classpath:/pictures/");
    }
}