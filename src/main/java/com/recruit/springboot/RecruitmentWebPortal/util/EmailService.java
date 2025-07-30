package com.recruit.springboot.RecruitmentWebPortal.util;

import java.util.List;

public interface EmailService {
    void sendOtpAndResetLink(String toEmail, String otp, String resetLink);
}