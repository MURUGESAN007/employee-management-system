package com.jsp.employee.util;

import com.jsp.employee.dto.EmployeeDto;
import com.jsp.employee.entity.Employee;

public class EmployeeMapper {

	public static Employee toEntity(EmployeeDto dto) {
		
		Employee e = new Employee();
		e.setAge(dto.getAge());
		e.setEmail(dto.getEmail());
		e.setGender(dto.getGender());
		e.setName(dto.getName());
		e.setRole(dto.getRole());
		e.setSalary(dto.getSalary());
		
		return e;
	}
	
	public static EmployeeDto toDto(Employee e) {
		
		EmployeeDto dto = new EmployeeDto();
		dto.setAge(e.getAge());
		dto.setEmail(e.getEmail());
		dto.setGender(e.getGender());
		dto.setName(e.getName());
		dto.setRole(e.getRole());
		dto.setSalary(e.getSalary());
		
		return dto;
	}
}
