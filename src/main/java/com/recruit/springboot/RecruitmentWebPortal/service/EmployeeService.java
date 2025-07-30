package com.recruit.springboot.RecruitmentWebPortal.service;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CreateUserDTO;
import com.recruit.springboot.RecruitmentWebPortal.DTO.EmployeeDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    String updateEmployee(Long id, EmployeeDTO employeeDTO);
    String deleteEmployee(Long id);
     String createUser(CreateUserDTO dto);
     String updateUser(Long id, CreateUserDTO dto);
String deleteUser(Long id);

}