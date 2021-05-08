package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getAllCountriesTest("IN");
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		testSearchCountry();
		testSearchCountryAndSort();
		testSearchCountryStartingWith();
	}

	private static void testGetAllCountries() {
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
	}

	private static void getAllCountriesTest(String code) throws CountryNotFoundException {
		Country country = countryService.findCountryByCode(code);
		LOGGER.debug("Country:{}", country);
	}
	
	private static void testAddCountry() throws CountryNotFoundException {
		countryService.addCountry(new Country("XY","Test Country"));
		Country country = countryService.findCountryByCode("XY");
		LOGGER.debug("Country:{}", country);
	}
	
	private static void testUpdateCountry() throws CountryNotFoundException {
		countryService.updateCountry("XY", "Name Changed");
		Country country = countryService.findCountryByCode("XY");
		LOGGER.debug("Country:{}", country);
	}
	
	private static void testDeleteCountry() {
		countryService.deleteCountry("XY");
		try {
			Country country = countryService.findCountryByCode("XY");
		} catch (CountryNotFoundException e) {
			LOGGER.debug("Country delected:{}", e.getMessage());
		}
	}
	
	//Day 2
	
	private static void testSearchCountry() {
		List<Country> countries = countryService.searchCountry("ou");
		LOGGER.debug("countries={}", countries);
	}
	
	private static void testSearchCountryAndSort() {
		List<Country> countries = countryService.searchCountryAndSort("ou");
		LOGGER.debug("countries={}", countries);
	}
	
	private static void testSearchCountryStartingWith() {
		List<Country> countries = countryService.searchCountryStartingWith("Z");
		LOGGER.debug("countries={}", countries);
	}
	
}
