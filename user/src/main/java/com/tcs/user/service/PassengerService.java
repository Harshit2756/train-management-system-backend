package com.tcs.user.service;

import com.tcs.user.dto.PassengerDetailsDTO;
import com.tcs.user.exception.PassengerNotFoundException;
import com.tcs.user.model.Gender;
import com.tcs.user.model.PassengerDetails;
import com.tcs.user.repository.PassengerDetailsRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

  @Autowired
  private PassengerDetailsRepository passengerDetailsRepository;

  public void addPassenger(Long customerId, PassengerDetailsDTO dto) {
    PassengerDetails passenger = new PassengerDetails(
      customerId,
      dto.getFullName(),
      dto.getAge(),
      (Gender) dto.getGender(),
      dto.getIdProofType(),
      dto.getIdProofNumber(),
      dto.getNationality(),
      LocalDateTime.now(),
      LocalDateTime.now()
    );
    passengerDetailsRepository.save(passenger);
  }

  public List<PassengerDetailsDTO> getPassengers(Long customerId) {
    return passengerDetailsRepository
      .findByCustomerId(customerId)
      .stream()
      .map(p ->
        new PassengerDetailsDTO(
          p.getFullName(),
          p.getAge(),
          p.getGender(),
          p.getIdProofType(),
          p.getIdProofNumber(),
          p.getNationality()
        )
      )
      .collect(Collectors.toList());
  }

  public void updatePassenger(Long passengerId, PassengerDetailsDTO dto) {
    Optional<PassengerDetails> passengerOpt = passengerDetailsRepository.findById(
      passengerId
    );
    if (passengerOpt.isPresent()) {
      PassengerDetails p = passengerOpt.get();
      p.setFullName(dto.getFullName());
      p.setAge(dto.getAge());
      p.setGender((Gender) dto.getGender());
      p.setIdProofType(dto.getIdProofType());
      p.setIdProofNumber(dto.getIdProofNumber());
      p.setNationality(dto.getNationality());
      p.setUpdatedAt(LocalDateTime.now());
      passengerDetailsRepository.save(p);
    } else {
      throw new PassengerNotFoundException(
        "Passenger not found with id: " + passengerId
      );
    }
  }

  public void deletePassenger(Long passengerId) {
    if (!passengerDetailsRepository.existsById(passengerId)) {
      throw new PassengerNotFoundException(
        "Passenger not found with id: " + passengerId
      );
    }
    passengerDetailsRepository.deleteById(passengerId);
  }
}
