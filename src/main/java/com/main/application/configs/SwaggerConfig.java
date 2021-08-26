package com.main.application.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.ant("/api/**"))
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Pademic Combat",
          "Some custom description of API.",
          "1.0",
          "Terms of service",
          new Contact("Arthur Oliveira", "", "arthuroliveira909@gmail.com"),
          "License of API",
          "API license URL",
          Collections.emptyList());
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers ( ResourceHandlerRegistry registry ) {

                registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
                registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

            }
        };
    }
}