package be.kdg.controllers;

import be.kdg.domain.reservation.CancellationFee;
import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.reservation.StatusReservation;
import be.kdg.domain.tool.Tool;
import be.kdg.domain.user.User;
import be.kdg.services.ReservationService;
import be.kdg.services.TransactionService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReservationController {
    private final ReservationService reservationService;
    private final TransactionService transactionService;

    @Autowired
    public ReservationController(ReservationService reservationService, TransactionService transactionService) {
        this.reservationService = reservationService;
        this.transactionService = transactionService;
    }

    // Ophalen van reservaties voor een specifieke gebruiker op een bepaalde datum
    public List<Reservation> showReservations(long borrowerId, LocalDate currentDate) {
        System.out.println("Controller: Fetching reservations for borrower: " + borrowerId + " on " + currentDate);
        return reservationService.showReservations(borrowerId, currentDate);
    }

    public void processPickup(long lenderId, long borrowerId, String reservationId) {
        System.out.println("Controller: Processing pickup for reservation: " + reservationId + " by Lender: " + lenderId);
        transactionService.createNewPickupTransaction();
    }

    // Bevestigen van een pickup
    public void confirmPickup(long lenderId, String reservationId) {
        System.out.println("Controller: Confirming pickup for reservation: " + reservationId + " by Lender: " + lenderId);

        // Retrieve the reservation
        Reservation reservation = reservationService.findReservation(reservationId);
        if (reservation == null) {
            System.out.println("Reservation not found: " + reservationId);
            return;
        }

        // Retrieve the borrower
        User borrower = reservation.getBorrower();
        if (borrower == null) {
            System.out.println("Borrower not found for reservation: " + reservationId);
            return;
        }

        // Calculate the total cost (loan price + deposit)
        int totalCost = reservation.getTool().getPurchasePrice() * (reservation.getEndDate().getDayOfYear() - reservation.getStartDate().getDayOfYear()) + reservation.getTool().getGuarantee();

        // Check if the borrower has enough sharepoints
        if (borrower.getSharepoints() >= totalCost) {
            // Proceed with the transaction
            transactionService.createPickupTransaction(reservationId);
            reservationService.updateReservationStatus(reservationId, "COMPLETED");
        } else {
            // Handle insufficient sharepoints
            System.out.println("Not enough sharepoints for borrower: " + borrower.getName());
            // Optionally, you can add logic to notify the borrower or take other actions
        }
    }

    // Annuleren van een reservatie
    public void cancelReservation(long lenderId, Reservation reservation) {
        System.out.println("Controller: Cancelling reservation: " + reservation.getId() + " by lender: " + lenderId);
        reservationService.cancelReservation(lenderId, reservation);
    }

    // Toevoegen van een nieuwe reservatie
    public void createReservation(String reservationId, Tool tool, long borrowerId, long lenderId, LocalDate startDate, LocalDate endDate, StatusReservation status, CancellationFee cancelationFee) {
        System.out.println("Controller: Creating reservation: " + reservationId + " for borrower: " + borrowerId + " and Date: " + startDate);
        reservationService.createReservation(reservationId, tool, borrowerId, lenderId, startDate, endDate, status, cancelationFee);
    }

    public List<Reservation> getNumberOfReservations(long lenderId) {
        return reservationService.getNumberOfReservations(lenderId);
    }

    public Reservation findReservationById(String reservationId) {
        return reservationService.findReservation(reservationId);
    }

    public Reservation findReservationByLenderId(long lenderId) {
        return reservationService.findReservationByLenderId(lenderId);
    }

    public Reservation findReservationByBorrowerId(long borrowerId) {
        return reservationService.findReservationByBorrowerId(borrowerId);
    }
}





























