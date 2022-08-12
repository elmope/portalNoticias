package com.portalNoticias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.portalNoticias.Repo")

public class PortalNoticiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalNoticiasApplication.class, args);
	}

}
