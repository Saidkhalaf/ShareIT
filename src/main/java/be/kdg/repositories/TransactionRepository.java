package be.kdg.repositories;

import be.kdg.domain.payment.SharepointTransaction;
import be.kdg.domain.payment.StatusPayment;
import be.kdg.domain.payment.Transaction;
import be.kdg.domain.payment.TransactionType;
import be.kdg.domain.reservation.Reservation;

import java.util.*;

import be.kdg.domain.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {
    private final Map<String, Transaction> transactions = new HashMap<>();

    public void createNewPickupTransaction() {
        // Create a new pickup transaction
        Transaction pickupTransaction = new Transaction(
                UUID.randomUUID().toString(),
                null,
                0,
                TransactionType.PICKUP
        );
        transactions.put(pickupTransaction.getTransactionId(), pickupTransaction);
    }

    public void createSharepointTransaction(Reservation reservation, int amount) {
        User borrower = reservation.getBorrower();
        User lender = reservation.getLender();
        lender.setSharepoints(lender.getSharepoints() + amount);
        borrower.setSharepoints(borrower.getSharepoints() - amount);
        Transaction depositTransaction = new Transaction(
                UUID.randomUUID().toString(),
                reservation.getId(),
                amount,
                TransactionType.DEPOSIT
        );
        transactions.put(depositTransaction.getTransactionId(), depositTransaction);
    }

    public void createDepositTransaction(Reservation reservation, int amount) {
        User borrower = reservation.getBorrower();
        User lender = reservation.getLender();
        lender.setSharepoints(lender.getSharepoints() + amount);
        borrower.setSharepoints(borrower.getSharepoints() - amount);
        Transaction depositTransaction = new Transaction(
                UUID.randomUUID().toString(),
                reservation.getId(),
                amount,
                TransactionType.DEPOSIT
        );
        transactions.put(depositTransaction.getTransactionId(), depositTransaction);
    }

    public void createCancellationTransaction(Reservation reservation, int amount) {
        User borrower = reservation.getBorrower();
        User lender = reservation.getLender();
        lender.setSharepoints(lender.getSharepoints() + amount);
        borrower.setSharepoints(borrower.getSharepoints() - amount);
        Transaction depositTransaction = new Transaction(
                UUID.randomUUID().toString(),
                reservation.getId(),
                amount,
                TransactionType.DEPOSIT
        );
        transactions.put(depositTransaction.getTransactionId(), depositTransaction);
    }

    // Haal pickup transacties op
    public List<SharepointTransaction> findPickupTransactions() {
        List<SharepointTransaction> pickupTransactions = new ArrayList<>();
        for (Transaction transaction : transactions.values()) {
            if (transaction.getType() == TransactionType.PICKUP) {
                // Maak een SharepointTransaction van de originele transactie
                SharepointTransaction spTransaction = new SharepointTransaction(
                        transaction.getAmount(), // Het bedrag van de transactie
                        new Date(), // Huidige datum
                        StatusPayment.COMPLETE, // Aangenomen als voltooid
                        null, // Gebruiker voor de betaling kan worden toegevoegd
                        null  // Extra gegevens kunnen worden toegevoegd
                );
                pickupTransactions.add(spTransaction);
            }
        }
        return pickupTransactions;
    }
}
