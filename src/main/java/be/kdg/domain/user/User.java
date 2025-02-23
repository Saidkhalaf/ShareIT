package be.kdg.domain.user;

import be.kdg.domain.payment.DepositTransaction;
import be.kdg.domain.payment.SharepointTransaction;
import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private long id;
    private String name;
    private String address;
    private String bankAccountNumber;
    private String email;
    private GeoLocation geoLocation;
    private int sharepoints;
    private List<SharepointTransaction> sharepointTransactionHistory;

    private List<DepositTransaction> depositTransactionHistory;

    public User(long id) {
        this.id = id;
    }

    public User(long Id, String name, String address, String bankAccountNumber, String email, GeoLocation geoLocation, int sharepoints) {
        this.id = Id;
        this.name = name;
        this.address = address;
        this.bankAccountNumber = bankAccountNumber;
        this.email = email;
        this.geoLocation = geoLocation;
        this.sharepoints = sharepoints;
    }

    // Getters en Setters

    public void setId(long id) {this.id = id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public void setSharepoints(int sharepoints) {
        this.sharepoints = sharepoints;
    }

    public void setSharepointTransactionHistory(List<SharepointTransaction> sharepointTransactionHistory) {
        this.sharepointTransactionHistory = sharepointTransactionHistory;
    }

    public void setDepositTransactionHistory(List<DepositTransaction> depositTransactionHistory) {
        this.depositTransactionHistory = depositTransactionHistory;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", email='" + email + '\'' +
                ", geoLocation=" + geoLocation +
                ", sharepoints=" + sharepoints +
                ", sharepointTransactionHistory=" + sharepointTransactionHistory +
                ", depositTransactionHistory=" + depositTransactionHistory +
                '}';
    }
}
