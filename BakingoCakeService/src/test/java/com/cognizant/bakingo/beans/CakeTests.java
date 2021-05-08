package com.cognizant.bakingo.beans;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.bakingo.bean.Cake;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CakeTests {

	private static Cake cake;

	@BeforeAll
	static void init() {
		cake=new Cake();
	}
	
	@Test
	void cakeSetterGetter() {
		String v="something";
		int x=10;
		
		cake.setAddress(v);
		Assertions.assertThat(cake.getAddress()).isEqualTo(v);
		
		cake.setFlavor(v);
		Assertions.assertThat(cake.getFlavor()).isEqualTo(v);
		
		cake.setName(v);
		Assertions.assertThat(cake.getName()).isEqualTo(v);
		
		cake.setPhonenumber("9876543210");
		Assertions.assertThat(cake.getPhonenumber()).isEqualTo("9876543210");
		
		cake.setTheinscription(v);
		Assertions.assertThat(cake.getTheinscription()).isEqualTo(v);
		
		cake.setFlavorRate(x);
		Assertions.assertThat(cake.getFlavorRate()).isEqualTo(x);
	}

}
