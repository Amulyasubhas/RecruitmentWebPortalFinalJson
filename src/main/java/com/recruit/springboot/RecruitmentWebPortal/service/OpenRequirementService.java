package com.recruit.springboot.RecruitmentWebPortal.service;

import com.recruit.springboot.RecruitmentWebPortal.DTO.OpenRequirementDTO;

import java.util.List;

public interface OpenRequirementService {
    OpenRequirementDTO create(OpenRequirementDTO dto);
    OpenRequirementDTO update(Long id, OpenRequirementDTO dto);
    void delete(Long id);
    // String delete(Long id);

    OpenRequirementDTO getById(Long id);
    List<OpenRequirementDTO> getAll();
}


