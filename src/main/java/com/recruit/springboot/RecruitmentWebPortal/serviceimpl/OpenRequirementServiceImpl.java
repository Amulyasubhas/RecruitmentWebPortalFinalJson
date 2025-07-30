package com.recruit.springboot.RecruitmentWebPortal.serviceimpl;

import com.recruit.springboot.RecruitmentWebPortal.DTO.OpenRequirementDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.OpenRequirement;
import com.recruit.springboot.RecruitmentWebPortal.entity.WorkTimings;
import com.recruit.springboot.RecruitmentWebPortal.repository.OpenRequirementRepository;
import com.recruit.springboot.RecruitmentWebPortal.service.OpenRequirementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class OpenRequirementServiceImpl implements OpenRequirementService {

    private final OpenRequirementRepository repository;
    private final AtomicLong serialCounter = new AtomicLong(1);

    public OpenRequirementServiceImpl(OpenRequirementRepository repository) {
        this.repository = repository;
    }
private OpenRequirementDTO mapToDTO(OpenRequirement entity) {
    OpenRequirementDTO dto = new OpenRequirementDTO();
    dto.setId(entity.getId());
    dto.setSerialNo(entity.getSerialNo());
    dto.setRole(entity.getRole());
    dto.setNoOfPositions(entity.getNoOfPositions());
    dto.setSkills(entity.getSkills());
    dto.setYearsOfExperience(entity.getYearsOfExperience());
    dto.setClientName(entity.getClientName());
    dto.setBudget(entity.getBudget());
    dto.setLocation(entity.getLocation());
    dto.setWorkTimings(entity.getWorkTimings() != null ? entity.getWorkTimings().getDisplayName() : null); // ✅ display string
    dto.setPriority(entity.getPriority());
    dto.setPositionStatus(entity.getPositionStatus());
    return dto;
}

private OpenRequirement mapToEntity(OpenRequirementDTO dto) {
    OpenRequirement entity = new OpenRequirement();
    entity.setSerialNo(dto.getSerialNo() != null ? dto.getSerialNo() : serialCounter.getAndIncrement());
    entity.setRole(dto.getRole());
    entity.setNoOfPositions(dto.getNoOfPositions());
    entity.setSkills(dto.getSkills());
    entity.setYearsOfExperience(dto.getYearsOfExperience());
    entity.setClientName(dto.getClientName());
    entity.setBudget(dto.getBudget());
    entity.setLocation(dto.getLocation());
    entity.setWorkTimings(dto.getWorkTimings() != null ? WorkTimings.fromDisplayName(dto.getWorkTimings()) : null); // ✅ enum from string
    entity.setPriority(dto.getPriority());
    entity.setPositionStatus(dto.getPositionStatus());
    return entity;
}


    @Override
    public OpenRequirementDTO create(OpenRequirementDTO dto) {
        OpenRequirement entity = mapToEntity(dto);
        return mapToDTO(repository.save(entity));
    }

    @Override
public OpenRequirementDTO update(Long id, OpenRequirementDTO dto) {
    OpenRequirement existing = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("OpenRequirement not found with ID: " + id));

    existing.setRole(dto.getRole());
    existing.setNoOfPositions(dto.getNoOfPositions());
    existing.setSkills(dto.getSkills());
    existing.setYearsOfExperience(dto.getYearsOfExperience());
    existing.setClientName(dto.getClientName());
    existing.setBudget(dto.getBudget());
    existing.setLocation(dto.getLocation());
    existing.setWorkTimings(dto.getWorkTimings() != null ? WorkTimings.fromDisplayName(dto.getWorkTimings()) : null); // ✅ FIXED
    existing.setPriority(dto.getPriority());
    existing.setPositionStatus(dto.getPositionStatus());

    return mapToDTO(repository.save(existing));
}


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public OpenRequirementDTO getById(Long id) {
        OpenRequirement entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("OpenRequirement not found with ID: " + id));
        return mapToDTO(entity);
    }

    @Override
    public List<OpenRequirementDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
