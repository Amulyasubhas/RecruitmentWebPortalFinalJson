package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.CandidateDetailsAndStatusTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.CandidateDetailsAndStatusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateDetailsAndStatusTrackerController {

    @Autowired
    private CandidateDetailsAndStatusTrackerService service;

    @PostMapping
    public CandidateDetailsAndStatusTrackerDTO create(@RequestBody CandidateDetailsAndStatusTrackerDTO dto) {
        String email = getCurrentUserEmail();
        return service.create(dto, email);
    }

    @GetMapping
    public List<CandidateDetailsAndStatusTrackerDTO> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public CandidateDetailsAndStatusTrackerDTO getById(@PathVariable Long id) {
    return service.getById(id);
}
  

    @PutMapping("/{id}")
    public CandidateDetailsAndStatusTrackerDTO update(@PathVariable Long id,
                                                      @RequestBody CandidateDetailsAndStatusTrackerDTO dto) {
        String email = getCurrentUserEmail();
        return service.update(id, dto, email);
    }
    
    @DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
    String email = getCurrentUserEmail();
    service.delete(id, email);
    return ResponseEntity.ok(" deleted successfully.");
}



    private String getCurrentUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            return (String) principal;
        } else {
            throw new RuntimeException("User is not authenticated or token is invalid.");
        }
    }
}
