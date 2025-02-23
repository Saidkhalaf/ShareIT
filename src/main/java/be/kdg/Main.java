package be.kdg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import be.kdg.controllers.PaymentController;
// import be.kdg.controllers.ReservationController;
// import be.kdg.domain.payment.Receipt;
// import be.kdg.domain.reservation.Reservation;
// import be.kdg.domain.reservation.StatusReservation;
// import be.kdg.domain.tool.Tool;
// import be.kdg.domain.tool.ToolType;
// import be.kdg.domain.user.User;
// import be.kdg.repositories.ReservationRepository;
// import be.kdg.repositories.TransactionRepository;
// import be.kdg.repositories.UserRepository;
// import be.kdg.services.PaymentService;
// import be.kdg.services.ReservationService;
// import be.kdg.services.TransactionService;

// import java.time.LocalDate;
// import java.util.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // // Gebruiker Eveline met 1000 SharePoints
        // User eveline = new User(1,"Eveline", "Address 1", "BE123456789", "eveline@example.com", null, 1000);

        // // Eveline's tools
        // Tool chainsaw = new Tool("Kettingzaag", new ToolType("Elektrisch gereedschap"), 10, "Kettingzaag", "Beschikbaar", true, new HashSet<>());
        // Tool drill = new Tool("Klopboormachine", new ToolType("Elektrisch gereedschap"), 20, "Klopboormachine", "Beschikbaar", true, new HashSet<>());
        // Tool kitchenRobot = new Tool("Keukenrobot", new ToolType("Keukengereedschap"), 15, "Keukenrobot", "Beschikbaar", true, new HashSet<>());

        // // Gebruiker Diederik met 1000 SharePoints
        // User diederik = new User(3,"Diederik", "Address 2", "BE987654321", "diederik@example.com", null, 1000);

        // // Diederik's tools
        // Tool paSeismic = new Tool("PA Seismic", new ToolType("Geluidsinstallatie"), 200, "PA Seismic", "Beschikbaar", true, new HashSet<>());
        // Tool blackStroboMagic = new Tool("Black Strobo Magic", new ToolType("Lichtinstallatie"), 50, "Black Strobo Magic", "Beschikbaar", true, new HashSet<>());

        // User albert = new User(2,"Albert", "Address 3", "BE123456789", "albert@example.com", null, 20);

        // // Reserveringen van Eveline
        // Reservation res10 = new Reservation("Res10",paSeismic, diederik,albert, LocalDate.of(2024,12,30), LocalDate.of(2025, 1, 1), StatusReservation.ACTIVE, null); // Reservering van PA Seismic door Diederik

        // // Reserveringen van Diederik
        // Reservation res1 = new Reservation("Res1",chainsaw, diederik,albert,LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 18), StatusReservation.ACTIVE, null);  // Reservering van Kettingzaag door Eveline
        // Reservation res2 = new Reservation("Res2",chainsaw, diederik,albert, LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 19), StatusReservation.ACTIVE, null);  // Reservering van Kettingzaag door Eveline
        // Reservation res3 = new Reservation("Res3",kitchenRobot,eveline,albert, LocalDate.of(2024, 12, 17), LocalDate.of(2024, 12, 19), StatusReservation.ACTIVE, null);  // Reservering van Keukenrobot door Eveline

        // // Initialiseer testdata voor gebruikers en reservaties
        // ReservationRepository reservationRepository = new ReservationRepository();
        // reservationRepository.updateReservation(res10);
        // reservationRepository.updateReservation(res1);
        // reservationRepository.updateReservation(res3);

        // // Initialiseer de ReservationService
        // UserRepository users = new UserRepository();
        // users.addUser(eveline);
        // users.addUser(diederik);

        // // Create TransactionRepository instance
        // TransactionRepository transactionRepository = new TransactionRepository();

        // ReservationService reservationService = new ReservationService(users, reservationRepository, transactionRepository);

        // TransactionService transactionService = new TransactionService(transactionRepository, users, reservationRepository);

        // ReservationController reservationController = new ReservationController(reservationService, transactionService);


        // // Bepaal de testdatum
        // LocalDate testDate = LocalDate.of(2024, 12, 15);

        // // Roep de controller aan om de reserveringen van Eveline te tonen
        // System.out.println("\n==== Show Reservations for Eveline on " + testDate + " ====");
        // List<Reservation> evelineReservations = reservationController.showReservations(1, testDate);
        // if (!evelineReservations.isEmpty()) {
        //     for (Reservation reservation : evelineReservations) {
        //         System.out.println("Reservation for tool: " + reservation.getTool().getName() + ", Status: " + reservation.getStatus());
        //     }
        // }

        // // Roep de controller aan om de reserveringen van Diederik te tonen
        // System.out.println("\n==== Show Reservations for Diederik on " + testDate + " ====");
        // List<Reservation> diederikReservations = reservationController.showReservations(3, testDate);
        // if (!diederikReservations.isEmpty()) {
        //     for (Reservation reservation : diederikReservations) {
        //         System.out.println("Reservation for tool: " + reservation.getTool().getName() + ", Status: " + reservation.getStatus());
        //     }
        // }

        // // Initialiseer de PaymentService
        // PaymentService paymentService = new PaymentService();

        // // Maak de PaymentController aan
        // PaymentController paymentController = new PaymentController(paymentService);

        // // Simuleer een betaling voor een tool die Eveline wil gebruiken (bijv. Kettingzaag voor 3 dagen)
        // System.out.println("\n==== Initiate Payment for Diederik ====");
        // double paymentAmount = 2 * 10;  // Kettingzaag voor 2 dagen à 10 SP per dag
        // double waarborg = 40;
        // double sumToPay = waarborg + paymentAmount;
        // Receipt receipt = paymentController.initiatePayment(sumToPay);
        // System.out.println("Payment processed successfully.");
        // System.out.println("Transaction ID: " + receipt.getTransactionId());
        // System.out.println("Amount: " + receipt.getAmount());
        // System.out.println("Status: " + receipt.getStatus());
        // System.out.println("Timestamp: " + receipt.getTimestamp());
    }
}

