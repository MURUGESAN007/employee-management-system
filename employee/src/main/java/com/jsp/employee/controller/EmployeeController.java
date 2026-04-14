package com.jsp.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.jsp.employee.dto.EmployeeDto;
import com.jsp.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public EmployeeDto save(@RequestBody EmployeeDto dto) {
        return service.save(dto);
    }

    // GET ALL
    @GetMapping
    public List<EmployeeDto> getAll() {
        return service.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable int id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable int id, @RequestBody EmployeeDto dto) {
        return service.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Employee deleted successfully";
    }

    // EXTRA APIs

    // Highest salary
    @GetMapping("/highest-salary")
    public EmployeeDto highestSalary() {
        return service.getHighestSalary();
    }

    // Average salary
    @GetMapping("/average-salary")
    public double averageSalary() {
        return service.getAverageSalary();
    }
    
 // Group by role
    @GetMapping("/group-by-role")
    public Map<String, List<EmployeeDto>> groupByRole() {
        return service.groupByRole();
    }

    // Total salary
    @GetMapping("/total-salary")
    public double totalSalary() {
        return service.getTotalSalary();
    }

    // Filter by role
    @GetMapping("/role/{role}")
    public List<EmployeeDto> getByRole(@PathVariable String role) {
        return service.getByRole(role);
    }

    // Sort by salary
    @GetMapping("/sort-salary")
    public List<EmployeeDto> sortSalary() {
        return service.sortBySalaryDesc();
    }

    // Count by gender
    @GetMapping("/count-gender")
    public Map<String, Long> countGender() {
        return service.countByGender();
    }
}