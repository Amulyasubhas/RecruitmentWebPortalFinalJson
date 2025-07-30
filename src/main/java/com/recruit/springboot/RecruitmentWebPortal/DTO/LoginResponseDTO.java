package com.recruit.springboot.RecruitmentWebPortal.DTO;

import java.util.List;

public class LoginResponseDTO {
    private String message;
    private String token;
    private Long userId;
    private List<String> roles;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String message, String token, Long userId, List<String> roles) {
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
