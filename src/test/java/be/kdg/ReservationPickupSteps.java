package be.kdg;

import be.kdg.controllers.ReservationController;
import be.kdg.controllers.TransactionController;
import be.kdg.controllers.UserController;
import be.kdg.domain.payment.SharepointTransaction;
import be.kdg.domain.reservation.Reservation;
import be.kdg.domain.reservation.StatusReservation;
import be.kdg.domain.tool.Tool;
import be.kdg.domain.tool.ToolSet;
import be.kdg.domain.tool.ToolType;
import be.kdg.domain.user.User;
import be.kdg.repositories.TransactionRepository;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.Assert.*;

@ContextConfiguration(classes = {CucumberSpringConfiguration.class})
public class ReservationPickupSteps {

    // geeft error dat er geen constructor is voor ReservationController, UserController en TransactionController maar is er wel vragen aan meneer hoe
    // dit op te lossen
    @Autowired
    private ReservationController reservationController;
    @Autowired
    private UserController userController;
    @Autowired
    private TransactionController transactionController;
    private LocalDate currentDate;
    private Map<String, User> users = new HashMap<>();
    private Map<String, Tool> tools = new HashMap<>();
    private Map<String, ToolType> toolTypes = new HashMap<>();
    private Map<Integer, ToolSet> toolSets = new HashMap<>();
    private TransactionRepository transactionRepository = new TransactionRepository();

    @Given("user")
    public void user(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        rows.forEach(row -> {
            long userId = Long.parseLong(row.get("id"));
            String userName = row.get("user_naam");
            String address = row.get("address");
            String bankAccountNumber = row.get("bankAccountNumber");
            String email = row.get("email");
            int sharepoints = Integer.parseInt(row.get("sharepoints"));
            userController.createUser(userId, userName, address, bankAccountNumber, email, sharepoints);
        });
    }

    // moet nog geupdate worden zodat het via de controller gaat
    @Given("toolType")
    public void toolType(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String type = row.get("type");
            int guarantee = Integer.parseInt(row.get("guarantee"));
            ToolType toolType = new ToolType(type, guarantee);
            toolTypes.put(toolType.getTypeDescription(),toolType);
        }
    }

    // moet nog geupdate worden zodat het via de controller gaat
    @Given("toolSets")
    public void toolsets(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            int id = Integer.parseInt(row.get("id"));
            String description = row.get("description");
            String type = row.get("type");
            String owner = row.get("owner");

            ToolSet toolSet = new ToolSet(id, description, toolTypes.get(type), users.get(owner), new ArrayList<>());
            toolSets.put(9, toolSet);
        }
    }

    // moet nog geupdate worden zodat het via de controller gaat
    @Given("tool")
    public void tool(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            int id = Integer.parseInt(row.get("id"));
            String name = row.get("name");
            String type = row.get("type");
            double dayPrice = Double.parseDouble(row.get("dayPrice"));
            int purchasePrice = Integer.parseInt(row.get("purchasePrice"));
            int current = Integer.parseInt(row.get("current"));
            String owner = row.get("owner");

            Tool tool = new Tool(name, toolTypes.get(type), purchasePrice, "Zaagkit", "", true, toolSets.get(9), 0);
            tools.put(tool.getName(), tool);
        }
    }

    // moet nog geupdate worden zodat het via de controller gaat
    @Given("toolSetContent")
    public void toolSetContent(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String setId = row.get("set");
            String toolId = row.get("tool");
        }
    }

    @Given("reservation")
    public void reservation(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String reservationId = row.get("reservation_id");
            String toolName = row.get("tool");
            Tool tool = tools.get(toolName); // Tool or ToolSet retrieval
            String borrowerName = row.get("borrower");
            String lenderName = row.get("lender");
            LocalDate startDate = LocalDate.parse(row.get("startDate"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate endDate = LocalDate.parse(row.get("endDate"), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            StatusReservation status = StatusReservation.valueOf(row.get("status"));

            User borrower = userController.findUserByName(borrowerName);
            User lender = userController.findUserByName(lenderName);

            if (borrower == null) {
                throw new IllegalArgumentException("Borrower not found: " + row.get("borrower"));
            }
            if (lender == null) {
                throw new IllegalArgumentException("Lender not found: " + row.get("lender"));
            }
            if (tool != null) {
                reservationController.createReservation(reservationId, tool, borrower.getId(), lender.getId(), startDate, endDate, status, null);
            } else {
                ToolSet toolSet = toolSets.get(9);
                reservationController.createReservation(reservationId, toolSet, borrower.getId(), lender.getId(), startDate, endDate, status, null);
            }
        }
    }

    @Given("today is {string}")
    public void todayIs(String arg0) {
        currentDate = LocalDate.parse(arg0,
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        assertTrue(currentDate.equals(LocalDate.parse("15-12-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"))) ||
                currentDate.equals(LocalDate.parse("21-12-2019", DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
    }

    @When("{string} aangeeft dat {string} zijn reservaties wil ophalen")
    public void theUserIndicatesThatAnotherUserWantsToPickUpHisReservations(String lenderName, String borrowerName) {
        User lender = userController.findUserByName(lenderName);
        User borrower = userController.findUserByName(borrowerName);
        reservationController.confirmPickup(lender.getId(), "Res1");
        reservationController.showReservations(borrower.getId(), currentDate);
    }

    @Then("wordt een lijst met {int} reservaties getoond")
    public void aListOfReservationsIsShown(int expectedReservations) {
        assertEquals(expectedReservations, reservationController.showReservations(3, currentDate).size());
    }

    @And("bevat de lijst {string}")
    public void theListContains(String reservationId) {
        Reservation res = reservationController.findReservationById(reservationId);
        assertNotNull(res);
    }

    @When("{string} aangeeft dat {string} {string} wil ophalen")
    public void theUserIndicatesThatAnotherUserWantsToPickUpTheReservation(String lenderName, String borrowerName,
                                                                           String reservationId) {
        User lender = userController.findUserByName(lenderName);
        User borrower = userController.findUserByName(borrowerName);
        reservationController.processPickup(lender.getId(), borrower.getId(), reservationId);
    }

    @And("{string} aangeeft dat {string} {string} wil annuleren")
    public void theUserIndicatesThatAnotherUserWantsToCancelTheReservation(String lenderName, String borrowerName,
                                                                           String reservationId) {
        User lender = userController.findUserByName(lenderName);
        User borrower = userController.findUserByName(borrowerName);
        Reservation res = reservationController.findReservationById(reservationId);
        reservationController.cancelReservation(borrower.getId(), res);
    }

    @And("{string} bevestigt de afhaling")
    public void theUserConfirmsThePickup(String lenderName) {
        User lender = userController.findUserByName(lenderName);
        Reservation res = reservationController.findReservationByLenderId(lender.getId());
        reservationController.confirmPickup(lender.getId(), res.getId());
    }

    @Then("wordt een afhalingtransactie aangemaakt")
    public void aPickupTransactionIsCreated() {
        transactionController.createNewPickupTransaction();
    }

    @And("wordt een transactielijn gemaakt voor de ontlening van {string} met een prijs van {int} SP")
    public void aTransactionLineIsCreatedForTheLoanOfToolWithAPriceOfSP(String res, int price) {
        Reservation ress = reservationController.findReservationById(res);
        assertNotNull(ress);
        transactionController.createSharepointTransaction(ress, price);
    }

    @And("wordt een transactielijn gemaakt voor de waarborg van {string} met een prijs van {int} SP")
    public void aTransactionLineIsCreatedForTheDepositAmountOfToolWithAPriceOfSP(String res, int price) {
        Reservation ress = reservationController.findReservationById(res);
        assertNotNull(ress);
        transactionController.createDepositTransaction(ress, price);
    }

    @And("wordt een transactielijn gemaakt voor annulatie van {string} met een prijs van {int} SP")
    public void aTransactionLineIsCreatedForTheAnnulationOfToolWithAPriceOfSP(String res, int price) {
        Reservation ress = reservationController.findReservationById(res);
        assertNotNull(ress);
        transactionController.createCancellationTransaction(ress, price);
    }

    @And("heeft {string} {int} SP")
    public void hasSP(String userName, int expectedSharepoints) {
        User user = userController.findUserByName(userName);
        assertNotNull(user);
        assertEquals(expectedSharepoints, user.getSharepoints());
    }

    @And("is de status van de ontlening onveranderd")
    public void isDeStatusVanDeOntleningOnveranderd() {
        Reservation res = reservationController.findReservationById("Res20");
        assertEquals(StatusReservation.ACTIVE, res.getStatus());
    }

    @Then("word er geen afhalingtransactie aangemaakt")
    public void word_er_geen_afhalingtransactie_aangemaakt() {
        List<SharepointTransaction> transactions = transactionRepository.findPickupTransactions();
        assertTrue(transactions.isEmpty());
    }
}