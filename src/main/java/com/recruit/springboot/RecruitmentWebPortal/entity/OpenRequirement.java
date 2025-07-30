package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.recruit.springboot.RecruitmentWebPortal.converter.WorkTimingsConverter;

import jakarta.persistence.*;

@Entity
@Table(name = "open_requirement") // Add this annotation
public class OpenRequirement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long serialNo;

    private String role;

    private Integer noOfPositions;

    private String skills;

    private Double yearsOfExperience;

    private String clientName;

    private String budget;

    private String location;
@Column(name = "work_timings", length = 50)
@Convert(converter = WorkTimingsConverter.class)
private WorkTimings workTimings;



    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private PositionStatus positionStatus;

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

    public WorkTimings getWorkTimings() {
        return workTimings;
    }

    public void setWorkTimings(WorkTimings workTimings) {
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