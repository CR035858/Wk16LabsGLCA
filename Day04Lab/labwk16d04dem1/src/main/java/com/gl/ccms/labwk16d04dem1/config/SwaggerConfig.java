package com.gl.ccms.labwk16d04dem1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
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
	public Docket ccCenterApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("CCare-APIx").select()
				.apis(RequestHandlerSelectors.basePackage("com.gl.ccms.labwk16d04dem1.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CC Center API").description("CCare Center API reference for developers")
				.termsOfServiceUrl("http:fakeLibrary.com")
				.contact(new Contact("CCare Center API", "http://fakeLibrary.com", "fakeLibrary@gmail.com"))
				.license("CCare Center License").licenseUrl("http;//fakeLibrary.com").build();
	}

}
