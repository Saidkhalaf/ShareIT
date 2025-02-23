package be.kdg.repositories;

import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.reservation.StatusReservation;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    private final HashMap<String, Reservation> reservations = new HashMap<>();

    public Reservation findReservationById(String reservationId) {
       return reservations.get(reservationId);
    }

    public void updateReservation(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    public List<Reservation> findAllReservations() {
        return new ArrayList<>(reservations.values());
    }

    public void add(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }

    public void updateReservationStatus(String reservationId, StatusReservation status) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation with ID " + reservationId + " does not exist.");
        }
        reservation.setStatus(status);
        reservations.put(reservationId, reservation); // Update the map
        System.out.println("Updated Reservation ID: " + reservationId + " to status: " + status);
    }

    public List<Reservation> findByBorrowerId(long borrowerId) {
        return this.reservations.values().stream()
                .filter(reservation -> reservation.getBorrower().getId() == borrowerId)
                .collect(Collectors.toList());
    }

    public List<Reservation> getNumberOfReservations(long lenderId) {
        return this.reservations.values().stream()
                .filter(reservation -> reservation.getLender().getId() == lenderId)
                .collect(Collectors.toList());
    }

    public Reservation findReservationByBorrowerId(long borrowerId) {
        return this.reservations.values().stream()
                .filter(reservation -> reservation.getBorrower().getId() == borrowerId)
                .findFirst()
                .orElse(null);
    }

    public Reservation findReservationByLenderId(long lenderId) {
        return this.reservations.values().stream()
                .filter(reservation -> reservation.getLender().getId() == lenderId)
                .findFirst()
                .orElse(null);
    }
}