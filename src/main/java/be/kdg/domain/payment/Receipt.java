package be.kdg.domain.payment;

import java.util.Date;

public class Receipt {

    private String transactionId;
    private double amount;
    private Date timestamp;
    private StatusPayment statusPayment;

    public Receipt(String transactionId, double amount, Date timestamp, StatusPayment statusPayment) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.statusPayment = statusPayment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public StatusPayment getStatus() {
        return statusPayment;
    }

    public void setStatus(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }
}

