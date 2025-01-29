package com.mdgn.autoMakler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.mdgn")
@EntityScan(basePackages = "com.mdgn")
@EnableJpaRepositories(basePackages = "com.mdgn")
@SpringBootApplication
public class AutoMaklerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMaklerApplication.class, args);
	}

}
