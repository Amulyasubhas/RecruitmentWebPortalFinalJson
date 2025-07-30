package com.recruit.springboot.RecruitmentWebPortal.repository;

import com.recruit.springboot.RecruitmentWebPortal.entity.InterviewTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface InterviewTrackerRepository extends JpaRepository<InterviewTracker, Long> {

    @Query("SELECT MAX(i.slNo) FROM InterviewTracker i")
    Optional<Integer> findMaxSlNo();
   
}
