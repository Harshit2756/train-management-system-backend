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

    /**
     * Processes a payment.
     *
     * NOTE: This is a mock implementation. In a real application, this method
     * would integrate with a payment gateway like Stripe or PayPal.
     *
     * @param payment The payment to process.
     * @return The processed payment.
     */
    public Payment processPayment(Payment payment) {
        // In a real implementation, you would use a payment gateway's API
        // to process the payment and get a real transaction ID and status.
        // For this demo, we will assume the payment is always successful.
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setGatewayResponse("Payment successful (mock implementation)");
        payment.setPaymentDate(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    public Payment getPaymentStatus(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }
}
