package be.kdg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.reservation.StatusReservation;
import be.kdg.repositories.ReservationRepository;
import be.kdg.repositories.TransactionRepository;
import be.kdg.repositories.UserRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }


    public void createPickupTransaction(String reservationId) {
        //find the reservation
        Reservation reservation = reservationRepository.findReservationById(reservationId);
        //Add a pickup transaction for the completed reservation
        transactionRepository.createNewPickupTransaction();
//        reservation.setStatus(StatusReservation.COMPLETED);
        reservationRepository.updateReservation(reservation);
    }

    public void createNewPickupTransaction() {
        transactionRepository.createNewPickupTransaction();
    }

    public void createSharepointTransaction(Reservation reservation, int amount) {
        transactionRepository.createSharepointTransaction(reservation, amount);
    }

    public void createDepositTransaction(Reservation reservation, int amount) {
        transactionRepository.createDepositTransaction(reservation, amount);
    }

    public void createCancellationTransaction(Reservation reservation, int amount) {
        transactionRepository.createCancellationTransaction(reservation, amount);
    }
}
