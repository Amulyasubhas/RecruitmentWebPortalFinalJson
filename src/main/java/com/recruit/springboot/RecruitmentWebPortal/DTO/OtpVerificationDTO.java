package com.recruit.springboot.RecruitmentWebPortal.DTO;
public class OtpVerificationDTO {
    private String email;
    private String otp;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}

