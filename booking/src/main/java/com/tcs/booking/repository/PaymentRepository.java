package com.tcs.booking.repository;

import com.tcs.booking.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
  Payment findByTransactionId(String transactionId);
}
