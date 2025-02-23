package be.kdg.domain.reservation;

import java.util.Date;

public class ReturnVerification {
    private String qrCode;
    private Date dateTime;
    private boolean verificationStatus;
    private double damageCompensation;

    public ReturnVerification(String qrCode, Date dateTime, boolean verificationStatus, double damageCompensation) {
        this.qrCode = qrCode;
        this.dateTime = dateTime;
        this.verificationStatus = verificationStatus;
        this.damageCompensation = damageCompensation;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(boolean verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public double getDamageCompensation() {
        return damageCompensation;
    }

    public void setDamageCompensation(double damageCompensation) {
        this.damageCompensation = damageCompensation;
    }
}
