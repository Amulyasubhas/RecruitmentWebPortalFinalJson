package com.recruit.springboot.RecruitmentWebPortal.controller;


import com.recruit.springboot.RecruitmentWebPortal.DTO.*;
import com.recruit.springboot.RecruitmentWebPortal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/send-login-otp")
    public String sendLoginOtp(@RequestBody LoginRequestDTO dto) {
        return authService.sendLoginOtp(dto);
    }

    @PostMapping("/resend-login-otp")
    public String resendLoginOtp(@RequestParam String email) {
        return authService.resendLoginOtp(email);
    }

    @PostMapping("/verify-login-otp")
    public String verifyLoginOtp(@RequestBody OtpVerificationDTO dto) {
        return authService.verifyLoginOtp(dto);
    }

    @PostMapping("/login-password")
    public LoginResponseDTO loginWithPassword(@RequestParam String email, @RequestParam String password) {
        return authService.loginWithPassword(email, password);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDTO dto) {
        return ResponseEntity.ok(authService.forgotPassword(dto));
    }

    @PostMapping("/resend-otp")
    public ResponseEntity<String> resendOtp(@RequestBody ForgotPasswordDTO dto) {
        return ResponseEntity.ok(authService.resendOtp(dto.getEmail()));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ConfirmResetPasswordDTO dto) {
        return ResponseEntity.ok(authService.verifyOtpAndResetPassword(dto));
    }
}
