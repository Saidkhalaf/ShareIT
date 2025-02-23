package be.kdg.domain.payment;

import java.util.Date;

public class DepositTransaction {

    private double depositAmount;
    private int sharepoints;
    private StatusPayment statusPayment;
    private Date timestamp;

    public DepositTransaction(double depositAmount, int sharepoints, StatusPayment statusPayment, Date timestamp) {
        this.depositAmount = depositAmount;
        this.sharepoints = sharepoints;
        this.statusPayment = statusPayment;
        this.timestamp = timestamp;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public int getSharepoints() {
        return sharepoints;
    }

    public void setSharepoints(int sharepoints) {
        this.sharepoints = sharepoints;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
