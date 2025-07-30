package com.recruit.springboot.RecruitmentWebPortal.DTO;

import java.time.LocalDate;

public class InterviewTrackerDTO {

    private Long id;
    private Integer slNo;
    private Long candidateId;

    private String candidateName;
    private String skill;
    private String vendor;
    private String recruiter;

    private String client;

    private LocalDate dateOfInterview;
    private String time;
    private String inviteStatus;
    private String interviewedBy;

    private String r1Status;
    private String r2Status;
    private String client1Status;
    private String client2Status;

    private String onboarding;
    private LocalDate onboardingDate;

    //  Getters and Setters

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

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
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

    public String getR1Status() {
        return r1Status;
    }

    public void setR1Status(String r1Status) {
        this.r1Status = r1Status;
    }

    public String getR2Status() {
        return r2Status;
    }

    public void setR2Status(String r2Status) {
        this.r2Status = r2Status;
    }

    public String getClient1Status() {
        return client1Status;
    }

    public void setClient1Status(String client1Status) {
        this.client1Status = client1Status;
    }

    public String getClient2Status() {
        return client2Status;
    }

    public void setClient2Status(String client2Status) {
        this.client2Status = client2Status;
    }

    public String getOnboarding() {
        return onboarding;
    }

    public void setOnboarding(String onboarding) {
        this.onboarding = onboarding;
    }

    public LocalDate getOnboardingDate() {
        return onboardingDate;
    }

    public void setOnboardingDate(LocalDate onboardingDate) {
        this.onboardingDate = onboardingDate;
    }
}

