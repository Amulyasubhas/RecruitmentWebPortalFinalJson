package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.OpenRequirementDTO;
import com.recruit.springboot.RecruitmentWebPortal.entity.WorkTimings;
import com.recruit.springboot.RecruitmentWebPortal.service.OpenRequirementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/open-requirements")
@CrossOrigin(origins = "*")
public class OpenRequirementController {

    private final OpenRequirementService service;

    public OpenRequirementController(OpenRequirementService service) {
        this.service = service;
    }

    // Create new Open Requirement
    @PostMapping
    public OpenRequirementDTO create(@RequestBody OpenRequirementDTO dto) {
        return service.create(dto);
    }

    // Update existing Open Requirement
    @PutMapping("/{id}")
    public OpenRequirementDTO update(@PathVariable Long id, @RequestBody OpenRequirementDTO dto) {
        return service.update(id, dto);
    }

    // Get Open Requirement by ID
    @GetMapping("/{id}")
    public OpenRequirementDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // Delete Open Requirement by ID with custom message
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(" deleted successfully.");
    }

    // Get all Open Requirements
    @GetMapping
    public List<OpenRequirementDTO> getAll() {
        return service.getAll();
    }

    //  New: Get Work Timings as display names for dropdown
    @GetMapping("/work-timings")
    public List<String> getWorkTimings() {
        return Arrays.stream(WorkTimings.values())
                .map(WorkTimings::getDisplayName)
                .collect(Collectors.toList());
    }
}
