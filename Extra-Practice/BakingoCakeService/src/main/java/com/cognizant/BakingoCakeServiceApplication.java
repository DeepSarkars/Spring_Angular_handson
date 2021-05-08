package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class BakingoCakeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakingoCakeServiceApplication.class, args);
	}

}
//994d3e4d04f9381adf20e44c4d7e8a897afe0005