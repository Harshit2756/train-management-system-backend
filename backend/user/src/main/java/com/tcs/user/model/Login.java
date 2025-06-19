package com.tcs.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "login")
public class Login {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long loginId;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private UserType userType;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status = Status.ACTIVE;

  @Column(nullable = false)
  private LocalDateTime createdAt;

  public Login() {}

  public Login(
    String email,
    String password,
    UserType userType,
    Status status,
    LocalDateTime createdAt
  ) {
    this.email = email;
    this.password = password;
    this.userType = userType;
    this.status = status;
    this.createdAt = createdAt;
  }

  public Long getLoginId() {
    return loginId;
  }

  public void setLoginId(Long loginId) {
    this.loginId = loginId;
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

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
