package com.cognizant.payroll;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.payroll.model.Employee;
import com.cognizant.payroll.service.DepartmentService;
import com.cognizant.payroll.service.EmployeeService;
import com.cognizant.payroll.service.SkillService;

public class Session2Application {

	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PayrollApplication.class);

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(PayrollApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		testGetAllPermanentEmployees();
		testGetAverageSalary();
		testGetAverageSalaryByDepartment();
//		testGetAllEmployees();
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
	}
	
	public static void testGetAverageSalary() {
		LOGGER.debug("Average Salary:{}", employeeService.getAverageSalary());
	}
	
	public static void testGetAverageSalaryByDepartment() {
		LOGGER.debug("Department Average Salary:{}", employeeService.getAverageSalary(1));
	}
	
	public static void testGetAllEmployees() {
		LOGGER.debug("All Employees:{}", employeeService.getAllEmployees());
	}
	
}
