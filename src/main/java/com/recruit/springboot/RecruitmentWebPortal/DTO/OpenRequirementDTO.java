package com.recruit.springboot.RecruitmentWebPortal.DTO;

import com.recruit.springboot.RecruitmentWebPortal.entity.PositionStatus;
import com.recruit.springboot.RecruitmentWebPortal.entity.Priority;

public class OpenRequirementDTO {

    private Long id;
    private Long serialNo;
    private String role;
    private Integer noOfPositions;
    private String skills;
    private Double yearsOfExperience;
    private String clientName;
    private String budget;
    private String location;
    private String workTimings; //changed from WorkTimings to String
    private Priority priority;
    private PositionStatus positionStatus;

    // getters and setters (including workTimings)

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSerialNo() {
        return serialNo;
    }
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Integer getNoOfPositions() {
        return noOfPositions;
    }
    public void setNoOfPositions(Integer noOfPositions) {
        this.noOfPositions = noOfPositions;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public Double getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(Double yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getBudget() {
        return budget;
    }
    public void setBudget(String budget) {
        this.budget = budget;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getWorkTimings() {
        return workTimings;
    }
    public void setWorkTimings(String workTimings) {
        this.workTimings = workTimings;
    }
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public PositionStatus getPositionStatus() {
        return positionStatus;
    }
    public void setPositionStatus(PositionStatus positionStatus) {
        this.positionStatus = positionStatus;
    }
}
