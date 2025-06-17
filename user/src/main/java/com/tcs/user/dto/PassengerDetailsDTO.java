package com.tcs.user.dto;

import com.tcs.user.model.Gender;

public class PassengerDetailsDTO {
    private String fullName;
    private Integer age;
    private Gender gender;
    private String idProofType;
    private String idProofNumber;
    private String nationality;

    public PassengerDetailsDTO() {
        super();
    }

    public PassengerDetailsDTO(String fullName, Integer age, Gender gender, String idProofType, String idProofNumber, String nationality) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.idProofType = idProofType;
        this.idProofNumber = idProofNumber;
        this.nationality = nationality;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public String getIdProofType() { return idProofType; }
    public void setIdProofType(String idProofType) { this.idProofType = idProofType; }
    public String getIdProofNumber() { return idProofNumber; }
    public void setIdProofNumber(String idProofNumber) { this.idProofNumber = idProofNumber; }
    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }
} 