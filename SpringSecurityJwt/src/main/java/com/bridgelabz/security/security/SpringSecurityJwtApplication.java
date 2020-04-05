package com.bridgelabz.security.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.bridgelabz.security.filters,com.bridgelabz.security.services,com.bridgelabz.security.util")
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}
}
/**
****purpose of this application
* 1. create a new authentication APi enpoint
* 2.examine every incoming request for valid jwt and authorize
*/