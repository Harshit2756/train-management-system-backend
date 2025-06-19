package com.tcs.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.user.dto.PassengerDetailsDTO;
import com.tcs.user.dto.UserProfileDTO;
import com.tcs.user.exception.PassengerNotFoundException;
import com.tcs.user.model.PassengerDetails;
import com.tcs.user.model.User;
import com.tcs.user.repository.PassengerDetailsRepository;
import com.tcs.user.repository.UserRepository;

@Service
public class PassengerService {

    @Autowired
    private PassengerDetailsRepository passengerRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public PassengerDetailsDTO addPassenger(Long userId, PassengerDetailsDTO dto) {
        User user = validateUser(userId);
        PassengerDetails passenger = new PassengerDetails();
        passenger.setUser(user);
        updatePassengerFromDTO(passenger, dto);
        PassengerDetails savedPassenger = passengerRepository.save(passenger);
        return convertToDTO(savedPassenger);
    }

    @Transactional(readOnly = true)
    public List<PassengerDetailsDTO> getPassengers(Long userId) {
        validateUser(userId);
        return passengerRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PassengerDetailsDTO getPassenger(Long userId, Long passengerId) {
        validateUser(userId);
        PassengerDetails passenger = passengerRepository.findByIdAndUserId(passengerId, userId)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with id: " + passengerId));
        return convertToDTO(passenger);
    }

    @Transactional
    public PassengerDetailsDTO updatePassenger(Long userId, Long passengerId, PassengerDetailsDTO dto) {
        validateUser(userId);
        PassengerDetails passenger = passengerRepository.findByIdAndUserId(passengerId, userId)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with id: " + passengerId));
        updatePassengerFromDTO(passenger, dto);
        PassengerDetails updatedPassenger = passengerRepository.save(passenger);
        return convertToDTO(updatedPassenger);
    }

    @Transactional
    public void deletePassenger(Long userId, Long passengerId) {
        validateUser(userId);
        PassengerDetails passenger = passengerRepository.findByIdAndUserId(passengerId, userId)
                .orElseThrow(() -> new PassengerNotFoundException("Passenger not found with id: " + passengerId));
        passengerRepository.delete(passenger);
    }

    @Transactional(readOnly = true)
    public UserProfileDTO getUserProfile(Long userId) {
        User user = validateUser(userId);
        List<PassengerDetails> passengers = passengerRepository.findByUserId(userId);
        return new UserProfileDTO(user, passengers);
    }

    private User validateUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + userId));
    }

    private void updatePassengerFromDTO(PassengerDetails passenger, PassengerDetailsDTO dto) {
        passenger.setName(dto.getName());
        passenger.setAge(dto.getAge());
        passenger.setGender(dto.getGender());
        passenger.setIdProofType(dto.getIdProofType());
        passenger.setIdProofNumber(dto.getIdProofNumber());

        // Set timestamps for new passengers
        if (passenger.getId() == null) {
            passenger.setCreatedAt(LocalDateTime.now());
        }
        passenger.setUpdatedAt(LocalDateTime.now());
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
}
