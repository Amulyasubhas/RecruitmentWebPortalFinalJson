package com.recruit.springboot.RecruitmentWebPortal.repository;

import com.recruit.springboot.RecruitmentWebPortal.entity.CandidateDetailsAndStatusTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CandidateDetailsAndStatusTrackerRepository extends JpaRepository<CandidateDetailsAndStatusTracker, Long> {
    List<CandidateDetailsAndStatusTracker> findByCreatedBy(String createdBy);
}
