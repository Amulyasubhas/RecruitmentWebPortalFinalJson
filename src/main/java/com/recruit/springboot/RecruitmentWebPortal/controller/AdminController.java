package com.recruit.springboot.RecruitmentWebPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CreateUserDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.EmployeeService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create-user")
    @PreAuthorize("hasRole('ADMIN')") // <-- Secure this method
    public String createUser(@RequestBody CreateUserDTO dto) {
        return employeeService.createUser(dto);
    }
    @PutMapping("/update-user/{id}")
@PreAuthorize("hasRole('ADMIN')")
public String updateUser(@PathVariable Long id, @RequestBody CreateUserDTO dto) {
    return employeeService.updateUser(id, dto);
}

@DeleteMapping("/delete-user/{id}")
@PreAuthorize("hasRole('ADMIN')")
public String deleteUser(@PathVariable Long id) {
    return employeeService.deleteUser(id);
}

}

