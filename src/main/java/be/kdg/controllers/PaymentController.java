package be.kdg.controllers;

import be.kdg.domain.payment.Receipt;
import be.kdg.domain.payment.SharepointTransaction;
import be.kdg.services.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {
    private PaymentService paymentProcessingService;

    @Autowired
    public PaymentController(PaymentService paymentProcessingService) {
        this.paymentProcessingService = paymentProcessingService;
    }

    public Receipt initiatePayment(double amount) {
        System.out.println("Controller: Initiating payment for amount: " + amount);
        return paymentProcessingService.processExternalPayment(amount);
    }
}
