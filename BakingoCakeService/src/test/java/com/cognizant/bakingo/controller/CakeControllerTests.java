package com.cognizant.bakingo.controller;

import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.cognizant.bakingo.bean.Cake;
import com.cognizant.bakingo.service.CakeService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CakeControllerTests {

	@Autowired
	CakeController cakeController;
	
	@MockBean
	BindingResult bindingResult;
	
	@Autowired
	CakeService cakeService;
	
	@Test
	void testShowCakeOrderForm() {
		String showCakeOrderForm = cakeController.showCakeOrderForm(new Cake());
		Assertions.assertThat(showCakeOrderForm).isEqualTo("placeOrder");
	}
	
	@Test
	void testGetOrderStatus() {
		Mockito.when(bindingResult.hasErrors()).thenReturn(true);
		Cake cake = new Cake();
		String orderStatus = cakeController.getOrderStatus(cake, bindingResult, new ModelMap());
		Assertions.assertThat(orderStatus).isEqualTo("placeOrder");
	}
	
	@Test
	void testGetOrderStatus_2() {
		Cake cake = new Cake();
		Mockito.when(bindingResult.hasErrors()).thenReturn(false);
		
		
		cake.setSelectedcake(1);
		cake.setName("Deep");
		cake.setAddress("asds");
		cake.setPhonenumber("9876543120");
		cake.setFlavor("Custard($5)");

		String orderStatus = cakeController.getOrderStatus(cake, bindingResult, new ModelMap());
		Assertions.assertThat(orderStatus).isEqualTo("orderStatus");
		
		cake.setIncludeCandles(1);
		cake.setFlavorRate(10);
		cake.setIncludeinscription(10);
		orderStatus = cakeController.getOrderStatus(cake, bindingResult, new ModelMap());
		Assertions.assertThat(orderStatus).isEqualTo("orderStatus");
	}
	
	@Test 
	void testPopulateFillingList() {
		Set<String> populateFillingList = cakeController.populateFillingList();
		Assertions.assertThat(populateFillingList).hasSize(8);
	}
}


