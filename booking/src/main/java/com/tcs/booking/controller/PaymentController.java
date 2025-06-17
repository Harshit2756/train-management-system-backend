package com.tcs.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.booking.model.Payment;
import com.tcs.booking.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping("/payment")
  public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
    return ResponseEntity.ok(paymentService.processPayment(payment));
  }

  @GetMapping("/payment/status/{transactionId}")
  public ResponseEntity<Payment> getPaymentStatus(
    @PathVariable String transactionId
  ) {
    return ResponseEntity.ok(paymentService.getPaymentStatus(transactionId));
  }
}
