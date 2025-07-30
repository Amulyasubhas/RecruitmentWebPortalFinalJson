package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CreateUserDTO;
import com.recruit.springboot.RecruitmentWebPortal.DTO.EmployeeDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
import com.recruit.springboot.RecruitmentWebPortal.repository.EmployeeRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.recruit.springboot.RecruitmentWebPortal.entity.Role;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create user (just name + email)
    @Override
    public String createUser(CreateUserDTO dto) {
        if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "User with this email already exists.";
        }

        Employee user = new Employee();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Set password
        if (dto.getRole() != null) {
            try {
                user.setRole(Role.valueOf(dto.getRole().toUpperCase()));
            } catch (IllegalArgumentException e) {
                return "Invalid role specified.";
            }
        } else {
            user.setRole(Role.RECRUITER); // Default to RECRUITER if not specified
        }
        employeeRepository.save(user);
        return "User created successfully.";
    }

    //  Add regular employee
    @Override
    public String addEmployee(EmployeeDTO dto) {
        if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
            return "Employee with this email already exists!";
        }

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        employeeRepository.save(emp);
        return "Employee added successfully!";
    }

    //  Get all employees
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //  Get employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    //  Update employee
    @Override
    public String updateEmployee(Long id, EmployeeDTO dto) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(dto.getName());
            emp.setEmail(dto.getEmail());
            employeeRepository.save(emp);
            return "Employee updated!";
        }).orElse("Employee not found!");
    }

    //  Delete employee
    @Override
    public String deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Deleted successfully!";
        }
        return "Employee not found!";
    }

    //  Admin update user
    @Override
    public String updateUser(Long id, CreateUserDTO dto) {
        return employeeRepository.findById(id).map(user -> {
            user.setName(dto.getName());
            user.setEmail(dto.getEmail());
            employeeRepository.save(user);
            return "User updated!";
        }).orElse("User not found!");
    }

    //  Admin delete user
    @Override
    public String deleteUser(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "User deleted!";
        }
        return "User not found!";
    }
}
