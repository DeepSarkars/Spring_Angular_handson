package com.cognizant.bakingo.controller;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.bakingo.bean.Cake;
import com.cognizant.bakingo.service.CakeService;

@Controller
public class CakeController {

	private static final String PLACE_ORDER = "placeOrder";

	@Autowired
	private CakeService cakeService;

	// add the code as per the requirement
	@GetMapping(value = "/showCakeOrderForm")
	public String showCakeOrderForm(@ModelAttribute("cake") Cake cake) {
		return PLACE_ORDER;
	}

	@PostMapping(value = "/orderStatus")
	public String getOrderStatus(@Valid @ModelAttribute("cake") Cake cake, BindingResult result, ModelMap map) {
		if (result.hasErrors())
			return PLACE_ORDER;

		int flavorRate = CakeService.getFlavorList().get(cake.getFlavor());

		if (cake.getIncludeCandles() == null)
			cake.setIncludeCandles(0); // To prevent NullPointerException

		if (cake.getIncludeinscription() == null)
			cake.setIncludeinscription(0);

		double price = (double) (cake.getSelectedcake() + flavorRate + cake.getIncludeCandles()
				+ cake.getIncludeinscription());
		cake.setPrice(price);

		int orderId = CakeService.addOrder(cake);

		map.addAttribute("cake", cake);
		map.addAttribute("indianPrice", cake.getPrice() * 75);
		map.addAttribute("orderId", orderId);
		map.addAttribute("orderDate", new Date().toString());

		return "orderStatus";

	}

	@ModelAttribute("flavorList")
	public Set<String> populateFillingList() {
		return CakeService.getFlavorList().keySet();
	}

}
