package be.kdg.domain.payment;
/**
 * Fares Ben Alita
 * 1-12-2024
 */

public class Transaction {
    private String transactionId;
    private String reservationId;
    private double amount;
    private TransactionType type;

    public Transaction(String transactionId, String reservationId, double amount, TransactionType type) {
        this.transactionId = transactionId;
        this.reservationId = reservationId;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + " | Reservation ID: " + reservationId +
                " | Amount: " + amount + " | Type: " + type;
    }
}
