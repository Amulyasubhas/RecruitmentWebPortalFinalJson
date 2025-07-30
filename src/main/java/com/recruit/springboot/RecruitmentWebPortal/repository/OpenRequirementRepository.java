package com.recruit.springboot.RecruitmentWebPortal.repository;

import com.recruit.springboot.RecruitmentWebPortal.entity.OpenRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpenRequirementRepository extends JpaRepository<OpenRequirement, Long> {
}