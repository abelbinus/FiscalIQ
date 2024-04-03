package com.main.FiscalIQ.service;

import com.main.FiscalIQ.model.Payment;

import java.sql.Timestamp;

public class PaymentService {

    // Mocking the third-party payment API call
    public static String addPayment(int userId, int amount, boolean paymentStatus) {
        // Assume calling the third-party payment API here and receiving the response
        // Mocking response data for demonstration
        Timestamp paymentTime = new Timestamp(System.currentTimeMillis()); // Current time as payment time

        // Creating Payment object with received data
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setPaymentTime(paymentTime);
        payment.setPaymentStatus(paymentStatus);
        return "";
    }
}