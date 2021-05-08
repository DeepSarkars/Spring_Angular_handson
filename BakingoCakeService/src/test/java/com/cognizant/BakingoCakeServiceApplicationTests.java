package com.cognizant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cognizant.bakingo.controller.CakeController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
class BakingoCakeServiceApplicationTests {
	@Autowired
	CakeController cakeController;
	@Test
	void contextLoads() {
		Assertions.assertThat(cakeController).isNotNull();
	}

	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	void appContext() {
		String[] args={};
		BakingoCakeServiceApplication.main(args);
		Assertions.assertThat(applicationContext).isNotNull();
		
	}
	
	
}
