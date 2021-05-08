package com.cognizant.payroll.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.payroll.model.Employee;
import com.cognizant.payroll.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Transactional
	public Employee get(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee != null)
			return employee.get();
		return null;
	}

	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	// Day2 Session 2

	@Transactional
	public List<Employee> getAllPermanentEmployees() {
		return employeeRepository.getAllPermanentEmployees();
	}

	@Transactional
	public double getAverageSalary() {
		return employeeRepository.getAverageSalary();
	}

	@Transactional
	public double getAverageSalary(int id) {
		return employeeRepository.getAverageSalary(id);
	}

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployeesNative();
	}

}
