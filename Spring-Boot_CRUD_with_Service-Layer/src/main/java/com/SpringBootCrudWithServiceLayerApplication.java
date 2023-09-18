package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCrudWithServiceLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudWithServiceLayerApplication.class, args);
		System.out.println("Spring-Boot CRUD With Service-Layer Application running on Port No 8585...");
	}

}
