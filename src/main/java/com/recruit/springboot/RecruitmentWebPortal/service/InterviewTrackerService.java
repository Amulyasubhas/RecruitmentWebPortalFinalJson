package com.recruit.springboot.RecruitmentWebPortal.service;

import java.util.List;

import com.recruit.springboot.RecruitmentWebPortal.DTO.InterviewTrackerDTO;

public interface InterviewTrackerService {
    InterviewTrackerDTO save(InterviewTrackerDTO dto);
    List<InterviewTrackerDTO> getAll();
    InterviewTrackerDTO getById(Long id);
    InterviewTrackerDTO update(Long id, InterviewTrackerDTO dto);
    void delete(Long id);
}
