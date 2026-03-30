import java.util.*;

/**
 * UC9: Error Handling & Validation
 * Version: 9.0
 */

// Custom Exception
class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

// Booking Service
class BookingService {

    private RoomInventory inventory;

    BookingService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void bookRoom(String customer, String roomType) {

        try {
            validate(roomType);

            int available = inventory.getInventory().get(roomType);
            inventory.getInventory().put(roomType, available - 1);

            System.out.println("Booking Successful for " + customer + " (" + roomType + ")");

        } catch (InvalidBookingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void validate(String roomType) throws InvalidBookingException {

        int available = inventory.getInventory().getOrDefault(roomType, -1);

        if (available == -1) {
            throw new InvalidBookingException("Invalid Room Type!");
        }

        if (available <= 0) {
            throw new InvalidBookingException("No rooms available!");
        }
    }
}

// Main
public class UC9ErrorHandlingValidation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService(inventory);

        service.bookRoom("Yash", "Single Room");   // valid
        service.bookRoom("Rahul", "Luxury Room");  // invalid
        service.bookRoom("Amit", "Suite Room");    // no availability
    }
}