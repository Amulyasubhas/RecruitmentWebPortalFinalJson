package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.InterviewTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.*;
import com.recruit.springboot.RecruitmentWebPortal.repository.CandidateDetailsAndStatusTrackerRepository;
import com.recruit.springboot.RecruitmentWebPortal.repository.InterviewTrackerRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.InterviewTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewTrackerServiceImpl implements InterviewTrackerService {

    @Autowired
    private InterviewTrackerRepository repository;

    @Autowired
    private CandidateDetailsAndStatusTrackerRepository candidateRepo;

    @Override
    public InterviewTrackerDTO save(InterviewTrackerDTO dto) {
        int nextSlNo = repository.findMaxSlNo().orElse(0) + 1;
        dto.setSlNo(nextSlNo);

        InterviewTracker entity = mapToEntity(dto);
        InterviewTracker saved = repository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public List<InterviewTrackerDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InterviewTrackerDTO getById(Long id) {
        InterviewTracker entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview Tracker entry not found with id: " + id));
        return mapToDTO(entity);
    }

    @Override
    @Transactional
    public InterviewTrackerDTO update(Long id, InterviewTrackerDTO dto) {
        InterviewTracker existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found with ID: " + id));

        dto.setId(id);
        dto.setSlNo(existing.getSlNo()); // keep the existing serial no

        InterviewTracker updated = mapToEntity(dto);
        updated.setCandidate(existing.getCandidate()); // avoid unnecessary re-fetch

        InterviewTracker saved = repository.save(updated);
        return mapToDTO(saved);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // ================= MAPPING METHODS =================

    private InterviewTracker mapToEntity(InterviewTrackerDTO dto) {
        InterviewTracker entity = new InterviewTracker();

        entity.setId(dto.getId());
        entity.setSlNo(dto.getSlNo());

        if (dto.getCandidateId() != null) {
            CandidateDetailsAndStatusTracker candidate = candidateRepo.findById(dto.getCandidateId())
                    .orElseThrow(() -> new RuntimeException("Candidate not found with ID: " + dto.getCandidateId()));
            entity.setCandidate(candidate);
        }

        entity.setCandidateName(dto.getCandidateName());
        entity.setSkill(dto.getSkill());
        entity.setVendor(dto.getVendor());
        entity.setRecruiter(dto.getRecruiter());

        entity.setClient(parseEnum(Client.class, dto.getClient()));
        entity.setR1Status(parseEnum(R1Status.class, dto.getR1Status()));
        entity.setR2Status(parseEnum(R2Status.class, dto.getR2Status()));
        entity.setClient1Status(parseEnum(Client1Status.class, dto.getClient1Status()));
        entity.setClient2Status(parseEnum(Client2Status.class, dto.getClient2Status()));
        entity.setOnboarding(parseEnum(Onboarding.class, dto.getOnboarding()));

        entity.setDateOfInterview(dto.getDateOfInterview());
        entity.setTime(dto.getTime());
        entity.setInviteStatus(dto.getInviteStatus());
        entity.setInterviewedBy(dto.getInterviewedBy());
        entity.setOnboardingDate(dto.getOnboardingDate());

        return entity;
    }

    private InterviewTrackerDTO mapToDTO(InterviewTracker entity) {
        InterviewTrackerDTO dto = new InterviewTrackerDTO();

        dto.setId(entity.getId());
        dto.setSlNo(entity.getSlNo());

        dto.setCandidateId(entity.getCandidate() != null ? entity.getCandidate().getId() : null);
        dto.setCandidateName(entity.getCandidateName());
        dto.setSkill(entity.getSkill());
        dto.setVendor(entity.getVendor());
        dto.setRecruiter(entity.getRecruiter());

        dto.setClient(entity.getClient() != null ? entity.getClient().name() : null);
        dto.setR1Status(entity.getR1Status() != null ? entity.getR1Status().name() : null);
        dto.setR2Status(entity.getR2Status() != null ? entity.getR2Status().name() : null);
        dto.setClient1Status(entity.getClient1Status() != null ? entity.getClient1Status().name() : null);
        dto.setClient2Status(entity.getClient2Status() != null ? entity.getClient2Status().name() : null);
        dto.setOnboarding(entity.getOnboarding() != null ? entity.getOnboarding().name() : null);

        dto.setDateOfInterview(entity.getDateOfInterview());
        dto.setTime(entity.getTime());
        dto.setInviteStatus(entity.getInviteStatus());
        dto.setInterviewedBy(entity.getInterviewedBy());
        dto.setOnboardingDate(entity.getOnboardingDate());

        return dto;
    }

    // ============ ENUM PARSER ============

    @SuppressWarnings("unchecked")
    private <E extends Enum<E>> E parseEnum(Class<E> enumType, String value) {
        if (value == null || value.isBlank()) return null;
        try {
            // Try custom fromString() method if exists
            try {
                return (E) enumType.getMethod("fromString", String.class).invoke(null, value);
            } catch (NoSuchMethodException e) {
                // Fallback: convert to ENUM_NAME format
                return Enum.valueOf(enumType, value.trim().toUpperCase().replace(" ", "_").replace("-", "_"));
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid enum value for " + enumType.getSimpleName() + ": " + value, e);
        }
    }
}
