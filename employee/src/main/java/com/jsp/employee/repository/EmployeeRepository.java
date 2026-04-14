package com.jsp.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
