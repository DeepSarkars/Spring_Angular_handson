package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	public List<Country> findByNameContaining(String search);
	public List<Country> findByNameContaining(String search, Sort sort);
	public List<Country> findByNameStartingWith(String search);
}
