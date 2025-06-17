package com.tcs.user.service;

import com.tcs.user.dto.UserProfileDTO;
import com.tcs.user.model.Customer;
import com.tcs.user.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private CustomerRepository customerRepository;

  public UserProfileDTO getProfile(String email) {
    Optional<Customer> customerOpt = customerRepository.findByEmail(email);
    if (customerOpt.isPresent()) {
      Customer c = customerOpt.get();
      return new UserProfileDTO(
        c.getName(),
        c.getEmail(),
        c.getContactNumber(),
        c.getAddress()
      );
    }
    throw new RuntimeException("User not found");
  }

  public void updateProfile(String email, UserProfileDTO dto) {
    Optional<Customer> customerOpt = customerRepository.findByEmail(email);
    if (customerOpt.isPresent()) {
      Customer c = customerOpt.get();
      c.setName(dto.getName());
      c.setContactNumber(dto.getContactNumber());
      c.setAddress(dto.getAddress());
      customerRepository.save(c);
    } else {
      throw new RuntimeException("User not found");
    }
  }

  public List<String> getBookingHistory(String email) {
    // Dummy data for booking history
    return List.of("Booking1", "Booking2");
  }

  public List<String> getUpcomingJourneys(String email) {
    // Dummy data for upcoming journeys
    return List.of("Journey1", "Journey2");
  }
}
