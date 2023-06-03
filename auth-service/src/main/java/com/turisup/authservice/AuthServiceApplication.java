package com.turisup.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {" com.turisup.userservice"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AuthServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
