package br.com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringdocConfig {

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Social Network API")
						.version("1.0")
						.description(""))
				.externalDocs(new ExternalDocumentation()
						.description("Access my Linkedin")
						.url("https://www.linkedin.com/in/katarine-albuquerque/"));
	}
}
