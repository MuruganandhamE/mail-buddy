package com.muruga.mail.buddy.config;

//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Mail Buddy API Service").version("1.0").description("Send Mail..."));
	}

//	@Bean
//	public GroupedOpenApi publicApi() {
//		return GroupedOpenApi.builder().group("public").pathsToMatch("/**").build();
//	}
}
