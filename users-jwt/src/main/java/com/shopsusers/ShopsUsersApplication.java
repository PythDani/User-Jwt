package com.shopsusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({"com.shops.commons.users.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class ShopsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsUsersApplication.class, args);
	}

}
