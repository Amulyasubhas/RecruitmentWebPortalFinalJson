package com.recruit.springboot.RecruitmentWebPortal.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class InterviewTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer slNo;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidateDetailsAndStatusTracker candidate;

    private String candidateName;
    private String skill;
    private String vendor;
    private String recruiter;

    @Enumerated(EnumType.STRING)
    private Client client;

    private LocalDate dateOfInterview;
    private String time;
    private String inviteStatus;
    private String interviewedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "r1_status")
    private R1Status r1Status;

    @Enumerated(EnumType.STRING)
    @Column(name = "r2_status")
    private R2Status r2Status;

    @Enumerated(EnumType.STRING)
    @Column(name = "client1_status")
    private Client1Status client1Status;

    @Enumerated(EnumType.STRING)
    @Column(name = "client2_status")
    private Client2Status client2Status;

    @Enumerated(EnumType.STRING)
    @Column(name = "onboarding")
    private Onboarding onboarding;

    private LocalDate onboardingDate;

    // --- Getters and Setters below (unchanged) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSlNo() {
        return slNo;
    }

    public void setSlNo(Integer slNo) {
        this.slNo = slNo;
    }

    public CandidateDetailsAndStatusTracker getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDetailsAndStatusTracker candidate) {
        this.candidate = candidate;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateOfInterview() {
        return dateOfInterview;
    }

    public void setDateOfInterview(LocalDate dateOfInterview) {
        this.dateOfInterview = dateOfInterview;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public String getInterviewedBy() {
        return interviewedBy;
    }

    public void setInterviewedBy(String interviewedBy) {
        this.interviewedBy = interviewedBy;
    }

    public R1Status getR1Status() {
        return r1Status;
    }

    public void setR1Status(R1Status r1Status) {
        this.r1Status = r1Status;
    }

    public R2Status getR2Status() {
        return r2Status;
    }

    public void setR2Status(R2Status r2Status) {
        this.r2Status = r2Status;
    }

    public Client1Status getClient1Status() {
        return client1Status;
    }

    public void setClient1Status(Client1Status client1Status) {
        this.client1Status = client1Status;
    }

    public Client2Status getClient2Status() {
        return client2Status;
    }

    public void setClient2Status(Client2Status client2Status) {
        this.client2Status = client2Status;
    }

    public Onboarding getOnboarding() {
        return onboarding;
    }

    public void setOnboarding(Onboarding onboarding) {
        this.onboarding = onboarding;
    }

    public LocalDate getOnboardingDate() {
        return onboardingDate;
    }

    public void setOnboardingDate(LocalDate onboardingDate) {
        this.onboardingDate = onboardingDate;
    }
}
