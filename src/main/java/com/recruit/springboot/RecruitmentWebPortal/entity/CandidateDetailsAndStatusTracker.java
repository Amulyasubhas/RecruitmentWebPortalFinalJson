package com.recruit.springboot.RecruitmentWebPortal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CandidateDetailsAndStatusTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String candidateName;
    private String skill;
    private String contactNumber;
    private String emailId;
    private String experience;
    private String relevantExp;
    private String ctc;
    private String ectc;
    private String noticePeriod;

    @Enumerated(EnumType.STRING)
    private CurrentLocation currentLocation;

    private String preferredLocation;
    private String vendor;

    @Enumerated(EnumType.STRING)
    private Recruiter recruiter;

    @Enumerated(EnumType.STRING)
    private Source source;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String comment;
    private String createdBy; // email of creator

    // Interviews mapping - if you want to auto-delete interviews on candidate delete
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<InterviewTracker> interviews = new ArrayList<>();

    // Getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCandidateName() { return candidateName; }
    public void setCandidateName(String candidateName) { this.candidateName = candidateName; }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }

    public String getRelevantExp() { return relevantExp; }
    public void setRelevantExp(String relevantExp) { this.relevantExp = relevantExp; }

    public String getCtc() { return ctc; }
    public void setCtc(String ctc) { this.ctc = ctc; }

    public String getEctc() { return ectc; }
    public void setEctc(String ectc) { this.ectc = ectc; }

    public String getNoticePeriod() { return noticePeriod; }
    public void setNoticePeriod(String noticePeriod) { this.noticePeriod = noticePeriod; }

    public CurrentLocation getCurrentLocation() { return currentLocation; }
    public void setCurrentLocation(CurrentLocation currentLocation) { this.currentLocation = currentLocation; }

    public String getPreferredLocation() { return preferredLocation; }
    public void setPreferredLocation(String preferredLocation) { this.preferredLocation = preferredLocation; }

    public String getVendor() { return vendor; }
    public void setVendor(String vendor) { this.vendor = vendor; }

    public Recruiter getRecruiter() { return recruiter; }
    public void setRecruiter(Recruiter recruiter) { this.recruiter = recruiter; }

    public Source getSource() { return source; }
    public void setSource(Source source) { this.source = source; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public List<InterviewTracker> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<InterviewTracker> interviews) {
        this.interviews = interviews;
    }
}
