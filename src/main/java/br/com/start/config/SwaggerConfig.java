package br.com.start.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API Filmes")
				.description("CRUD de filmes")
				.version("0.1")
				.license("")
				.licenseUrl()
				.contact()
				.build();
	}

}
