package com.cognizant.payroll.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.payroll.model.Department;
import com.cognizant.payroll.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public Department get(int id) {
		return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department department) {
		departmentRepository.save(department);
	}
	

}
