package be.kdg.domain.reservation;

import java.util.Date;

public class PickUpVerification {

    private String qrCode;
    private Date dateTime;
    private boolean verificationStatus;

    public PickUpVerification(String qrCode, Date dateTime, boolean verificationStatus) {
        this.qrCode = qrCode;
        this.dateTime = dateTime;
        this.verificationStatus = verificationStatus;
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
}
