package com.tcs.user.dto;

public class UserRegistrationDTO {

  private String name;
  private String email;
  private String password;
  private String contactNumber;
  private String address;

  public UserRegistrationDTO() {}

  public UserRegistrationDTO(
    String name,
    String email,
    String password,
    String contactNumber,
    String address
  ) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.contactNumber = contactNumber;
    this.address = address;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
}
