import java.util.LinkedList;
import java.util.Queue;

/**
 * UC5: Booking Request Queue (FIFO)
 * Version: 5.0
 */

// Reservation class
class Reservation {

    String customerName;
    String roomType;

    Reservation(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Customer: " + customerName + " | Room: " + roomType);
    }
}

// Booking Queue
class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation r) {
        queue.add(r);
        System.out.println("Added to queue:");
        r.display();
    }

    // View queue
    public void showQueue() {
        System.out.println("\n=== Booking Queue ===");

        for (Reservation r : queue) {
            r.display();
        }
    }
}

// Main
public class UC5BookingRequestQueue {

    public static void main(String[] args) {

        BookingQueue bookingQueue = new BookingQueue();

        // Add requests (FIFO)
        bookingQueue.addRequest(new Reservation("Yash", "Single Room"));
        bookingQueue.addRequest(new Reservation("Rahul", "Double Room"));
        bookingQueue.addRequest(new Reservation("Amit", "Suite Room"));

        // Show queue
        bookingQueue.showQueue();
    }
}