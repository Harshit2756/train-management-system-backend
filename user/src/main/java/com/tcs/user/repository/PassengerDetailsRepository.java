package com.tcs.user.repository;

import com.tcs.user.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {
    List<PassengerDetails> findByCustomerId(Long customerId);
} 