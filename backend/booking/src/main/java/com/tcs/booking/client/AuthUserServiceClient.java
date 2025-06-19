package com.tcs.booking.client;

import org.springframework.stereotype.Component;

@Component
public class AuthUserServiceClient {
    public boolean validateUser(Long customerId) {
        // Dummy implementation: always return true
        return true;
    }
} 