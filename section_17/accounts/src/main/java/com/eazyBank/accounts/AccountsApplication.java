package com.eazyBank.accounts;

import com.eazyBank.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef ="auditAwareImpl")
@OpenAPIDefinition(
		info=@Info(
title = "Accounts microservice REST API Documnentation",
description = "EazyBank Accounts microservice REST API Documnentation",
version = "v1",
contact =  @Contact(
		name = "Shruti Puri",
		email="ShrutiPuri1301@gmail.com",
	    url  ="localhost:8080/accounts" /* e.g*/
		)
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);

	}
}
