package com.recruit.springboot.RecruitmentWebPortal.service;

import java.util.List;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;

public interface CandidateDetailsAndStatusTrackerService {
    CandidateDetailsAndStatusTrackerDTO create(CandidateDetailsAndStatusTrackerDTO dto, String currentUserEmail);
    List<CandidateDetailsAndStatusTrackerDTO> getAll();
    CandidateDetailsAndStatusTrackerDTO update(Long id, CandidateDetailsAndStatusTrackerDTO dto, String currentUserEmail);
    CandidateDetailsAndStatusTrackerDTO getById(Long id);
    void delete(Long id, String userEmail);
}
