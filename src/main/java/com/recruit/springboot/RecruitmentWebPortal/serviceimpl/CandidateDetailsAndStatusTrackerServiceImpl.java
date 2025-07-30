package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.CandidateDetailsAndStatusTracker;
import com.recruit.springboot.RecruitmentWebPortal.repository.CandidateDetailsAndStatusTrackerRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.CandidateDetailsAndStatusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateDetailsAndStatusTrackerServiceImpl implements CandidateDetailsAndStatusTrackerService {

    @Autowired
    private CandidateDetailsAndStatusTrackerRepository repo;

    @Override
    public CandidateDetailsAndStatusTrackerDTO create(CandidateDetailsAndStatusTrackerDTO dto, String userEmail) {
        CandidateDetailsAndStatusTracker entity = mapToEntity(dto);
        entity.setCreatedBy(userEmail);
        return mapToDTO(repo.save(entity));
    }

    @Override
    public List<CandidateDetailsAndStatusTrackerDTO> getAll() {
        return repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public CandidateDetailsAndStatusTrackerDTO getById(Long id) {
        CandidateDetailsAndStatusTracker entity = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
        return mapToDTO(entity);
    }

    @Override
    public CandidateDetailsAndStatusTrackerDTO update(Long id, CandidateDetailsAndStatusTrackerDTO dto, String userEmail) {
        CandidateDetailsAndStatusTracker existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
        if (!existing.getCreatedBy().equals(userEmail)) {
            throw new SecurityException("You are not allowed to update this record.");
        }
        CandidateDetailsAndStatusTracker updated = mapToEntity(dto);
        updated.setId(id);
        updated.setCreatedBy(userEmail);
        return mapToDTO(repo.save(updated));
    }

    @Override
    public void delete(Long id, String userEmail) {
        CandidateDetailsAndStatusTracker existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + id));
        if (!existing.getCreatedBy().equals(userEmail)) {
            throw new SecurityException("You are not allowed to delete this record.");
        }
        repo.deleteById(id);
    }

    private CandidateDetailsAndStatusTracker mapToEntity(CandidateDetailsAndStatusTrackerDTO dto) {
        CandidateDetailsAndStatusTracker e = new CandidateDetailsAndStatusTracker();
        e.setDate(dto.getDate());
        e.setCandidateName(dto.getCandidateName());
        e.setSkill(dto.getSkill());
        e.setContactNumber(dto.getContactNumber());
        e.setEmailId(dto.getEmailId());
        e.setExperience(dto.getExperience());
        e.setRelevantExp(dto.getRelevantExp());
        e.setCtc(dto.getCtc());
        e.setEctc(dto.getEctc());
        e.setNoticePeriod(dto.getNoticePeriod());
        e.setCurrentLocation(dto.getCurrentLocation());
        e.setPreferredLocation(dto.getPreferredLocation());
        e.setVendor(dto.getVendor());
        e.setRecruiter(dto.getRecruiter());
        e.setSource(dto.getSource());
        e.setStatus(dto.getStatus());
        e.setComment(dto.getComment());
        return e;
    }

    private CandidateDetailsAndStatusTrackerDTO mapToDTO(CandidateDetailsAndStatusTracker e) {
        CandidateDetailsAndStatusTrackerDTO dto = new CandidateDetailsAndStatusTrackerDTO();
        dto.setId(e.getId());
        dto.setDate(e.getDate());
        dto.setCandidateName(e.getCandidateName());
        dto.setSkill(e.getSkill());
        dto.setContactNumber(e.getContactNumber());
        dto.setEmailId(e.getEmailId());
        dto.setExperience(e.getExperience());
        dto.setRelevantExp(e.getRelevantExp());
        dto.setCtc(e.getCtc());
        dto.setEctc(e.getEctc());
        dto.setNoticePeriod(e.getNoticePeriod());
        dto.setCurrentLocation(e.getCurrentLocation());
        dto.setPreferredLocation(e.getPreferredLocation());
        dto.setVendor(e.getVendor());
        dto.setRecruiter(e.getRecruiter());
        dto.setSource(e.getSource());
        dto.setStatus(e.getStatus());
        dto.setComment(e.getComment());
        return dto;
    }
}
