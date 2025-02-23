package be.kdg.domain.reservation;

import be.kdg.domain.tool.Tool;
import be.kdg.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Reservation {
//todo: voeg adds en removes nog in alle domein klassen
    private String id;
    private Tool tool;
    private User borrower;
    private User lender;
    private LocalDate startDate;
    private LocalDate endDate;
    private StatusReservation status;
    private CancellationFee cancellationFee;

    public Reservation(String id, Tool tool, User borrower, User lender, LocalDate startDate, LocalDate endDate, StatusReservation status, CancellationFee cancellationFee) {
        this.id = id;
        this.tool = tool;
        this.borrower = borrower;
        this.lender = lender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.cancellationFee = cancellationFee;
    }

    public void setId(String id) {this.id = id;}

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void setBorrower(User borrower) {this.borrower = borrower;}

    public void setLender(User lender) {this.lender = lender;}

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCancellationFee(CancellationFee cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public void setStatus(StatusReservation status) {
        this.status = status;
    }

    public int calculateCancellationFee() {
        long daysBeforeCancellation = LocalDate.now().until(startDate, ChronoUnit.DAYS);

        if (daysBeforeCancellation < 3) {
            return 4;
        } else if (daysBeforeCancellation < 7) {
            return 4;
        } else {
            return 0;
        }
    }



}
