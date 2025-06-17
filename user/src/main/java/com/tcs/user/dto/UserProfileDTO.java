package com.tcs.user.dto;

public class UserProfileDTO {
    private String name;
    private String email;
    private String contactNumber;
    private String address;

    public UserProfileDTO() {}

    public UserProfileDTO(String name, String email, String contactNumber, String address) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
} 