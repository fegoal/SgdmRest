package com.propia.sgdm;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	 @Bean
     public Docket productApi() {
         return new Docket(DocumentationType.SWAGGER_2)
             .select()
             .apis(RequestHandlerSelectors.basePackage("com.propia.sgdm.web"))
              .paths(regex("/articulos.*"))
              .build();
     }

	   private ApiInfo usersApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Service User")
	                .version("0.1")
	                .license("No es para vender")
	                .build();
	    }
}
