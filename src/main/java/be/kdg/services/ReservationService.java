package be.kdg.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import be.kdg.domain.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.kdg.domain.payment.DepositTransaction;
import be.kdg.domain.payment.SharepointTransaction;
import be.kdg.domain.reservation.CancellationFee;
import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.reservation.StatusReservation;
import be.kdg.domain.user.User;
import be.kdg.repositories.ReservationRepository;
import be.kdg.repositories.TransactionRepository;
import be.kdg.repositories.UserRepository;

@Service
public class ReservationService {

    private final UserRepository users;
    private final ReservationRepository reservationRepository;
    private final TransactionRepository transactionRepository;
    private final List<DepositTransaction> depositTransactions = new ArrayList<>();
    private final List<SharepointTransaction> sharepointTransactions = new ArrayList<>();

    @Autowired
    public ReservationService(UserRepository users, ReservationRepository reservationRepository, TransactionRepository transactionRepository) {
        this.users = users;
        this.reservationRepository = reservationRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Reservation> showReservations(long borrowerId, LocalDate currentDate) {
        List<Reservation> reservations = reservationRepository.findByBorrowerId(borrowerId);
        return reservations.stream()
                .filter(reservation -> reservation.getStartDate().equals(currentDate))
                .collect(Collectors.toList());
    }

    public void addReservation(Reservation reservation) {
        reservationRepository.updateReservation(reservation);
    }

    public User findUser(long borrowerId) {
        return users.getUserById(borrowerId);
    }

    public Reservation findReservation(String reservationId) {
        return reservationRepository.findReservationById(reservationId);
    }

    public void cancelReservation(long lenderId, Reservation reservation) {
        // Stel de status van de reservering in op CANCELLED
        reservation.setStatus(StatusReservation.CANCELLED);
        reservationRepository.updateReservation(reservation);
    }

    public void updateReservationStatus(String reservationId, String status) {
        Reservation reservation = findById(reservationId);
        reservation.setStatus(StatusReservation.valueOf(status));
        System.out.println("Service: Reservation " + reservationId + " updated to status: " + status);
    }

    private Reservation findById(String reservationId) {
        return reservationRepository.findReservationById(reservationId);
    }


    public void createReservation(String reservationId, Tool tool, long borrowerId, long lenderId, LocalDate startDate, LocalDate endDate, StatusReservation status, CancellationFee cancelationFee) {
        User borrower = findUser(borrowerId);
        User lender = findUser(lenderId);
        Reservation reservation = new Reservation(reservationId, tool, borrower, lender, startDate, endDate, status, cancelationFee);
        reservationRepository.updateReservation(reservation);
    }

    public List<Reservation> getNumberOfReservations(long lenderId) {
        return reservationRepository.getNumberOfReservations(lenderId);
    }

    public Reservation getReservation(String reservationId) {
        return reservationRepository.findReservationById(reservationId);
    }

    public Reservation findReservationByBorrowerId(long borrowerId) {
        return reservationRepository.findReservationByBorrowerId(borrowerId);
    }

    public Reservation findReservationByLenderId(long lenderId) {
        return reservationRepository.findReservationByLenderId(lenderId);
    }

}