package com.cognizant.ormlearn.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.CountryRepository;
import com.cognizant.ormlearn.exception.CountryNotFoundException;
import com.cognizant.ormlearn.model.Country;

@Service
public class CountryService {
	@Autowired
	private CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if(result.isEmpty())
			throw new CountryNotFoundException(countryCode+" Country not found");
		return result.get();
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException {
		Country country=this.findCountryByCode(code);
		country.setName(name);
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String code) {
		countryRepository.deleteById(code);
	}
	
	//Day 2 Session 1 
	@Transactional
	public List<Country> searchCountry(String search) {
		return countryRepository.findByNameContaining(search);
	}
	
	@Transactional
	public List<Country> searchCountryAndSort(String search) {
		return countryRepository.findByNameContaining(search, Sort.by(Sort.Direction.ASC, "name"));
	}
	
	@Transactional
	public List<Country> searchCountryStartingWith(String search) {
		return countryRepository.findByNameStartingWith(search);
	}
}
