package io.pn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.pn.service.UserServiceImpl;

@SpringBootApplication
public class SpringBasicsDataApplication{
	
	@Autowired
	UserServiceImpl userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBasicsDataApplication.class, args);
	}

	
}
