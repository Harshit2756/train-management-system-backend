package com.tcs.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.user.model.PassengerDetails;

@Repository
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Long> {

    List<PassengerDetails> findByUserId(Long userId);

    Optional<PassengerDetails> findByIdAndUserId(Long id, Long userId);
}
