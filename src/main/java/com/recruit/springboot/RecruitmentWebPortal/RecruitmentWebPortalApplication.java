package com.recruit.springboot.RecruitmentWebPortal;

import com.recruit.springboot.RecruitmentWebPortal.entity.Employee;
import com.recruit.springboot.RecruitmentWebPortal.entity.Role;
import com.recruit.springboot.RecruitmentWebPortal.repository.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class RecruitmentWebPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentWebPortalApplication.class, args);
	}

	@Bean
	public CommandLineRunner initAdmin(EmployeeRepository repository, PasswordEncoder encoder) {
		return args -> {
			if (repository.findByEmail("admin@example.com").isEmpty()) {
				Employee admin = new Employee();
				admin.setName("Super Admin");
				admin.setEmail("admin@example.com");
				admin.setPassword(encoder.encode("admin123")); // default password
				admin.setRole(Role.ADMIN); // adjust based on how you define roles
				repository.save(admin);
				System.out.println(" Default Admin created: admin@example.com / admin123");
			} else {
				System.out.println(" Admin already exists.");
			}
		};
	}
}