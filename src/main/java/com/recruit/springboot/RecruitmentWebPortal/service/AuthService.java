package com.recruit.springboot.RecruitmentWebPortal.service;

import com.recruit.springboot.RecruitmentWebPortal.DTO.*;

public interface AuthService {
    String sendLoginOtp(LoginRequestDTO dto);
    String resendLoginOtp(String email);

    String verifyLoginOtp(OtpVerificationDTO dto);
    LoginResponseDTO loginWithPassword(String email, String password);

    String forgotPassword(ForgotPasswordDTO dto);
    String resendOtp(String email);
   String verifyOtpAndResetPassword(com.recruit.springboot.RecruitmentWebPortal.DTO.ConfirmResetPasswordDTO dto);
 
}
