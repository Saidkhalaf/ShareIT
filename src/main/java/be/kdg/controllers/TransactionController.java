package be.kdg.controllers;

import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.user.User;
import be.kdg.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {
    public final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void createNewPickupTransaction() {
        transactionService.createNewPickupTransaction();
    }

    public void createSharepointTransaction(Reservation reservation, int amount) {
        transactionService.createSharepointTransaction(reservation, amount);
    }

    public void createDepositTransaction(Reservation reservation, int amount) {
        transactionService.createDepositTransaction(reservation, amount);
    }

    public void createCancellationTransaction(Reservation reservation, int amount) {
        transactionService.createCancellationTransaction(reservation, amount);
    }
}
