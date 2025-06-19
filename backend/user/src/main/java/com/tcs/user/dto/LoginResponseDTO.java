package com.tcs.user.dto;

import com.tcs.user.model.Status;
import com.tcs.user.model.User;
import com.tcs.user.model.UserType;

public class LoginResponseDTO {

    private Long userId;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private UserType userType;
    private Status status;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.contactNumber = user.getContactNumber();
        this.address = user.getAddress();
        this.userType = user.getUserType();
        this.status = user.getStatus();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
