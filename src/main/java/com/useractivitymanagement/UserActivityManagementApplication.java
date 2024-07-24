package com.useractivitymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserActivityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserActivityManagementApplication.class, args);
	}

}
