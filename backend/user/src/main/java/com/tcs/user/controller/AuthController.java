package com.tcs.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.user.dto.AdminRegistrationDTO;
import com.tcs.user.dto.ApiResponse;
import com.tcs.user.dto.LoginDTO;
import com.tcs.user.dto.LoginResponseDTO;
import com.tcs.user.dto.UserRegistrationDTO;
import com.tcs.user.exception.InvalidCredentialsException;
import com.tcs.user.service.AuthService;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> registerUser(@RequestBody UserRegistrationDTO dto) {
        authService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(null, "User registered successfully"));
    }

    @PostMapping("/admin/register")
    public ResponseEntity<ApiResponse<String>> registerAdmin(@RequestBody AdminRegistrationDTO dto) {
        authService.registerAdmin(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(null, "Admin registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> login(@RequestBody LoginDTO dto) {
        LoginResponseDTO loginResponse = authService.login(dto);
        return ResponseEntity.ok(ApiResponse.success(loginResponse, "Login successful"));
    }

    @PutMapping("/activate/{userId}")
    public ResponseEntity<ApiResponse<String>> activateAccount(@PathVariable Long userId) {
        try {
            authService.activateAccount(userId);
            return ResponseEntity.ok(ApiResponse.success(null, "Account activated successfully"));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error("ALREADY_ACTIVE", e.getMessage()));
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.error("INVALID_CREDENTIALS", e.getMessage()));
        }
    }
}
