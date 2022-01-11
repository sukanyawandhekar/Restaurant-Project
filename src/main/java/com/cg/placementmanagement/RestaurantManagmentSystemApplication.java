package com.cg.placementmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"com.cg.placementmanagement","com.cg.placementmanagement.controller","com.cg.placementmanagement.service","com.cg.placementmanagement.entities","com.cg.placementmanagement.repository","com.cg.placementmanagement.exceptions"})
@EntityScan({"com.cg.placementmanagement"})
@EnableJpaRepositories({"com.cg.placementmanagement.repository"})

public class RestaurantManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantManagmentSystemApplication.class, args);
	}

}
