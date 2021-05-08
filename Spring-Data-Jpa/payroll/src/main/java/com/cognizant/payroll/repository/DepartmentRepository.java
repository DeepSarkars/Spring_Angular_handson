package com.cognizant.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.payroll.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
