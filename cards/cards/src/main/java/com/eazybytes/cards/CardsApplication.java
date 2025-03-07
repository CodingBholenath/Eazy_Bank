package com.eazybytes.cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info=@Info(
                title = "Cards microservice REST API Documnentation",
                description = "EazyBank Cards microservice REST API Documnentation",
                version = "v2",
                contact =  @Contact(
                        name = "Shruti Puri",
                        email="ShrutiPuri1301@gmail.com",
                        url  ="localhost:9001/accounts" /* e.g*/
                )
        )
)
public class CardsApplication {

	public static void main(String[] args) {

        SpringApplication.run(CardsApplication.class, args);
	}

}
