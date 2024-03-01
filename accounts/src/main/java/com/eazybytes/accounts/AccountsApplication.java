package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.ResponseDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication //following comment is necessary for that case, if we have our components in different packages
/*@ComponentScans({
		@ComponentScan("com.eazybytes.accounts.controller"),
		@ComponentScan("com.eazybytes.accounts.service")
})
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.com.entity")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info= @Info(
				title="Accounts mircoservice REST API Documentation",
				description = "MyBank Accounts microservice REST API Documentation",
				version="v1",
				contact = @Contact(
						name="Arthur Sharipov",
						email = "sharipov.a.m@mail.ru",
						url = "https://exampleWebsite.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://apacheExample.com"
				)
		),
		externalDocs= @ExternalDocumentation(
				description = "MyBank Accounts mircoservice REST API Documentation",
				url = "https://myWebsite.com/swagger-ui.html"

)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
