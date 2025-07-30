package com.recruit.springboot.RecruitmentWebPortal.controller;



import com.recruit.springboot.RecruitmentWebPortal.DTO.EmployeeDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
import com.recruit.springboot.RecruitmentWebPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public String create(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<Employee> readAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee readOne(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return employeeService.deleteEmployee(id);
    }
}
