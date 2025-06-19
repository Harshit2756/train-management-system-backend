package com.tcs.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.booking.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByTransactionId(String transactionId);

    // Find all payments for a booking
    java.util.List<Payment> findByBookingId(Long bookingId);

    // Find all payments by status
    java.util.List<Payment> findByStatus(com.tcs.booking.model.PaymentStatus status);
}
