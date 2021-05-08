package com.cognizant.bakingo.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cake {

	@NotNull(message = "Must select one Option")
	private Integer selectedcake;

	private String flavor;
	private Integer flavorRate;
	private Integer includeCandles;
	private Integer includeinscription;
	private String theinscription;

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Address is required")
	private String address;

	@NotEmpty(message = "Phone number is required")
	@Pattern(regexp = "^[\\d]{10}$", message = "Phone number should be 10 digits")
	private String phonenumber;

	private double price;

}
