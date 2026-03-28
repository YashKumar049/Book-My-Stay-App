/**
 * UC2: Basic Room Types & Static Availability
 * Book My Stay App
 * Version: 2.0
 */

// Abstract Class
abstract class Room {
    String type;
    int beds;
    double price;

    // Constructor
    Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    // Abstract method
    abstract void displayDetails();
}

// Single Room
class SingleRoom extends Room {

    SingleRoom() {
        super("Single Room", 1, 1000);
    }

    void displayDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: " + price);
    }
}

// Double Room
class DoubleRoom extends Room {

    DoubleRoom() {
        super("Double Room", 2, 2000);
    }

    void displayDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: " + price);
    }
}

// Suite Room
class SuiteRoom extends Room {

    SuiteRoom() {
        super("Suite Room", 3, 5000);
    }

    void displayDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: " + price);
    }
}

// Main Class
public class UC2RoomInitialization {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay App (v2.0) =====");

        // Polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display
        r1.displayDetails();
        System.out.println("Available: " + singleAvailable);

        r2.displayDetails();
        System.out.println("Available: " + doubleAvailable);

        r3.displayDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}