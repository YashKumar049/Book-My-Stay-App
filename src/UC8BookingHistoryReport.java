import java.util.*;

/**
 * UC8: Booking History & Reporting
 * Version: 8.0
 */

// Reservation class
class Reservation {
    String customerName;
    String roomType;
    String reservationId;

    Reservation(String reservationId, String customerName, String roomType) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println(reservationId + " | " + customerName + " | " + roomType);
    }
}

// Booking History
class BookingHistory {

    private List<Reservation> history = new ArrayList<>();

    // Add booking
    public void addReservation(Reservation r) {
        history.add(r);
        System.out.println("Added to history: " + r.reservationId);
    }

    // Show history
    public void showHistory() {

        System.out.println("\n=== Booking History ===");

        for (Reservation r : history) {
            r.display();
        }
    }

    // Simple report
    public void generateReport() {

        System.out.println("\n=== Report ===");
        System.out.println("Total Bookings: " + history.size());

        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : history) {
            countMap.put(r.roomType, countMap.getOrDefault(r.roomType, 0) + 1);
        }

        for (String type : countMap.keySet()) {
            System.out.println(type + " : " + countMap.get(type));
        }
    }
}

// Main
public class UC8BookingHistoryReport {

    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();

        // Add bookings
        history.addReservation(new Reservation("R1", "Yash", "Single Room"));
        history.addReservation(new Reservation("R2", "Rahul", "Double Room"));
        history.addReservation(new Reservation("R3", "Amit", "Single Room"));

        // Show history
        history.showHistory();

        // Report
        history.generateReport();
    }
}