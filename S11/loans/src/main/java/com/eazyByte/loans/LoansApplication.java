package com.eazyByte.loans;

import com.eazyByte.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")

@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "EazyBank Loans microservice REST API Documentation",
				version = "v3",
				contact = @Contact(name = "Shruti",
						email = "shrutipuri13224@gmail.com",
						url = "https://www.eazybytes.com"
				)
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
