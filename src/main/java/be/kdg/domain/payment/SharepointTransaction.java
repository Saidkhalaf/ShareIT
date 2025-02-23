package be.kdg.domain.payment;

import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.user.User;

import java.util.Date;

public class SharepointTransaction {
    private double sharepoints;
    private Date timestamp;
    private StatusPayment statusPayment;
    private User fromUser;
    private User toUser;
    private Reservation reservation;

    public SharepointTransaction(double sharepoints, Date timestamp, StatusPayment statusPayment, User fromUser, User toUser) {
        this.sharepoints = sharepoints;
        this.timestamp = timestamp;
        this.statusPayment = statusPayment;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    public SharepointTransaction(int sharepoints, Date timestamp, StatusPayment statusPayment, User fromUser, User toUser, Reservation reservation) {
        this.sharepoints = sharepoints;
        this.timestamp = timestamp;
        this.statusPayment = statusPayment;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.reservation = reservation;
    }

    public double getSharepoints() {
        return sharepoints;
    }

    public void setSharepoints(int sharepoints) {
        this.sharepoints = sharepoints;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public Reservation getReservation() {return reservation;}

    public void setReservation(Reservation reservation) {this.reservation = reservation;}
}
