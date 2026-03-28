import java.util.HashMap;
import java.util.Map;

/**
 * UC3: Centralized Room Inventory Management
 * Version: 3.0
 */

// Inventory Class
class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();

        // Initialize data
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("=== Current Inventory ===");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

// Main Class
public class UC3CentralizedInventory {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        // Update example
        System.out.println("\nUpdating Single Room count...");

        inventory.updateAvailability("Single Room", 4);

        // Display after update
        inventory.displayInventory();
    }
}