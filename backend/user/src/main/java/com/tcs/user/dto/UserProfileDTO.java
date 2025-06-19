package com.tcs.user.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tcs.user.model.PassengerDetails;
import com.tcs.user.model.User;
import com.tcs.user.model.UserType;

public class UserProfileDTO {

    private Long userId;
    private String name;
    private String email;
    private String contactNumber;
    private String address;
    private UserType userType;
    private List<PassengerDetailsDTO> passengers;

    public UserProfileDTO() {
    }

    public UserProfileDTO(User user, List<PassengerDetails> passengers) {
        this.userId = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.contactNumber = user.getContactNumber();
        this.address = user.getAddress();
        this.userType = user.getUserType();
        this.passengers = passengers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PassengerDetailsDTO convertToDTO(PassengerDetails passenger) {
        PassengerDetailsDTO dto = new PassengerDetailsDTO();
        dto.setId(passenger.getId());
        dto.setName(passenger.getName());
        dto.setAge(passenger.getAge());
        dto.setGender(passenger.getGender());
        dto.setIdProofType(passenger.getIdProofType());
        dto.setIdProofNumber(passenger.getIdProofNumber());
        return dto;
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

    public List<PassengerDetailsDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDetailsDTO> passengers) {
        this.passengers = passengers;
    }
}
