package com.recruit.springboot.RecruitmentWebPortal.DTO;
public class ConfirmResetPasswordDTO {
    private String otp;
    private String newPassword;
    private String confirmPassword;

    // Getters & Setters
    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getConfirmPassword() { return confirmPassword; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}