package be.kdg.services;

import be.kdg.domain.payment.Receipt;
import be.kdg.domain.payment.StatusPayment;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Receipt processExternalPayment(double amount) {
        System.out.println("Processing external payment of: " + amount);

        String transactionId = UUID.randomUUID().toString();

        return new Receipt(transactionId, amount, new Date(), StatusPayment.COMPLETE);
    }
}
