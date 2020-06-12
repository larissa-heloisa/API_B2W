package com.larissaheloisa.apib2w.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket apiB2W() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.larissaheloisa.apib2w"))
				.paths(PathSelectors.regex("/planets.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("B2W Desafio Desenvolvedoras")
				.description("API Rest consumindo a API pública de Star Wars")
				.version("1.0")
				.license("Apache License Version 4.0")
				.contact(new Contact("Larissa Heloisa", "https://www.linkedin.com/in/larissa-heloisa-lh/", 
						"larissaheloisalh@gmail.com"))
				.build();
	}


}
