package com.tcs.user.service;

import com.tcs.user.exception.EmailFormatException;
import com.tcs.user.util.EmailValidator;
import org.springframework.stereotype.Service;

@Service
public class EmailValidationService {
    public void validateEmail(String email) {
        if (!EmailValidator.isValidEmail(email)) {
            throw new EmailFormatException("Invalid email format: " + email);
        }
    }
} 