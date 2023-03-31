package com.shops.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;




@EntityScan({"com.shops.commons.users.models.entity"})
@SpringBootApplication
public class ShopsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsUsersApplication.class, args);
	}

}
