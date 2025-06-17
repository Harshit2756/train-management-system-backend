package com.tcs.booking.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.booking.model.Payment;
import com.tcs.booking.model.PaymentStatus;
import com.tcs.booking.repository.PaymentRepository;

@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  public Payment processPayment(Payment payment) {
    payment.setStatus(PaymentStatus.SUCCESS);
    payment.setPaymentDate(LocalDateTime.now());
    return paymentRepository.save(payment);
  }

  public Payment getPaymentStatus(String transactionId) {
    return paymentRepository.findByTransactionId(transactionId);
  }
}
