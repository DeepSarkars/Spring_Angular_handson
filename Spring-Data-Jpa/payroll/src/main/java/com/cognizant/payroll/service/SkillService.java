package com.cognizant.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.payroll.model.Skill;
import com.cognizant.payroll.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	@Transactional
	public Skill get(int id) {
		return skillRepository.findById(id).get();
	}

}
