package com.tcs.user.dto;

import com.tcs.user.model.User;

public class LoginResponseDTO {

    private User user;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
