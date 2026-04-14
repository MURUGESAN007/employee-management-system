package com.jsp.employee.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jsp.employee.dto.EmployeeDto;
import com.jsp.employee.entity.Employee;
import com.jsp.employee.exception.ResourceNotFoundException;
import com.jsp.employee.repository.EmployeeRepository;
import com.jsp.employee.util.EmployeeMapper;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public EmployeeDto save(EmployeeDto dto) {
        Employee emp = EmployeeMapper.toEntity(dto);
        return EmployeeMapper.toDto(repo.save(emp));
    }

    // GET ALL
    public List<EmployeeDto> getAll() {
        return repo.findAll()
                .stream()
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public EmployeeDto getById(int id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        return EmployeeMapper.toDto(emp);
    }

    // UPDATE
    public EmployeeDto update(int id, EmployeeDto dto) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setAge(dto.getAge());
        emp.setEmail(dto.getEmail());
        emp.setRole(dto.getRole());
        emp.setSalary(dto.getSalary());
        emp.setGender(dto.getGender());

        return EmployeeMapper.toDto(repo.save(emp));
    }

    // DELETE
    public void delete(int id) {
        Employee emp = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        repo.delete(emp);
    }

    // COLLECTIONS LOGIC (IMPORTANT)

    // Highest salary
    public EmployeeDto getHighestSalary() {
        Employee emp = repo.findAll()
                .stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .orElseThrow(() -> new ResourceNotFoundException("No employees found"));

        return EmployeeMapper.toDto(emp);
    }

    // Average salary
    public double getAverageSalary() {
        return repo.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }
    
    //groupByRole
    public Map<String, List<EmployeeDto>> groupByRole() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getRole,
                        Collectors.mapping(EmployeeMapper::toDto, Collectors.toList())
                ));
    }
    
    //getTotalSalary
    public double getTotalSalary() {
        return repo.findAll()
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }
    
    //getByRole
    public List<EmployeeDto> getByRole(String role) {
        return repo.findAll()
                .stream()
                .filter(e -> e.getRole().equalsIgnoreCase(role))
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }
    
    //sortBySalaryDesc
    public List<EmployeeDto> sortBySalaryDesc() {
        return repo.findAll()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .map(EmployeeMapper::toDto)
                .collect(Collectors.toList());
    }
    
    //countByGender
    public Map<String, Long> countByGender() {
        return repo.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.counting()
                ));
    }
}