package com.cognizant.payroll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Fetch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.payroll.model.Department;
import com.cognizant.payroll.model.Employee;
import com.cognizant.payroll.model.Skill;
import com.cognizant.payroll.service.DepartmentService;
import com.cognizant.payroll.service.EmployeeService;
import com.cognizant.payroll.service.SkillService;

@SpringBootApplication
public class PayrollApplication {
	
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(PayrollApplication.class);

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(PayrollApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		testAddEmployee();
		testGetEmployee();
		testGetEmployeeAndDepartment();
		testGetDepartmentAndEmployees();
		testGetSkill();
		testGetEmployeeAndDepartmentAndSkills();
	}
	
	private static void testAddEmployee() throws ParseException {
		String dob = "01/08/1999";
		Employee employee = new Employee(5, "z", 2000, false, new SimpleDateFormat("dd/MM/yyyy").parse(dob));
		employee.setDepartment(departmentService.get(1));
		employeeService.save(employee);
	}
	
	private static void testGetEmployee() {
		LOGGER.debug("Employee {}",employeeService.get(2));
	}
	
	private static void testGetEmployeeAndDepartment() {
		Employee employee = employeeService.get(2);
		LOGGER.debug("Employee {}",employee);
		LOGGER.debug("Department {}",employee.getDepartment());
	}
	
	private static void testGetDepartmentAndEmployees() {
		Department department = departmentService.get(1);
		LOGGER.debug("Department {}",department);
		LOGGER.debug("Employee {}",department.getEmployeeList());
	}
	
	private static void testGetEmployeeAndDepartmentAndSkills() {
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee {}",employee);
		LOGGER.debug("Department {}",employee.getDepartment());
		Set<Skill> skills= employee.getSkillList();
		LOGGER.debug("Skills:{}", skills);
	}
	
	private static void testGetSkill() {
		Skill skill = skillService.get(1);
		LOGGER.debug("Skill {}",skill);
		LOGGER.debug("Employees {}",skill.getEmployeeList());
	}
}
