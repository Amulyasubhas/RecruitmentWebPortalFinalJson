package com.recruit.springboot.RecruitmentWebPortal.controller;

import com.recruit.springboot.RecruitmentWebPortal.DTO.InterviewTrackerDTO;
import com.recruit.springboot.RecruitmentWebPortal.service.InterviewTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview-tracker")
public class InterviewTrackerController {

    @Autowired
    private InterviewTrackerService service;

    @PostMapping
    public InterviewTrackerDTO create(@RequestBody InterviewTrackerDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<InterviewTrackerDTO> getAll() {
        return service.getAll();
    }
     @GetMapping("/{id}")
    public InterviewTrackerDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public InterviewTrackerDTO update(@PathVariable Long id, @RequestBody InterviewTrackerDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
public ResponseEntity<String> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.ok(" deleted successfully.");
}

}
