package be.kdg.domain.reservation;

public class CancellationFee {
    private int amount;
    private int penaltyPoints;

    // Constructor
    public CancellationFee(int amount, int penaltyPoints) {
        this.amount = amount;
        this.penaltyPoints = penaltyPoints;
    }

    // Getter voor het bedrag van de annuleringskosten
    public int getAmount() {
        return amount;
    }

    // Setter voor het bedrag van de annuleringskosten
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // Getter voor de penalty points
    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    // Setter voor de penalty points
    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    @Override
    public String toString() {
        return "Amount: " + amount + ", Penalty Points: " + penaltyPoints;
    }
}
