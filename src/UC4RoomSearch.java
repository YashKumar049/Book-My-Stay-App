import java.util.HashMap;
import java.util.Map;

/**
 * UC4: Room Search & Availability Check
 * Version: 4.0
 */

// ✅ Renamed Inventory (no conflict)
class RoomInventoryUC4 {

    private HashMap<String, Integer> inventory;

    public RoomInventoryUC4() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 0);
        inventory.put("Suite Room", 2);
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}

// ✅ Renamed Room (no conflict)
class RoomUC4 {

    String type;
    int beds;
    double price;

    RoomUC4(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    void display() {
        System.out.println(type + " | Beds: " + beds + " | Price: " + price);
    }
}

// Search Service
class RoomSearchService {

    public void search(RoomInventoryUC4 inventory) {

        Map<String, Integer> data = inventory.getInventory();

        System.out.println("=== Available Rooms ===");

        for (Map.Entry<String, Integer> entry : data.entrySet()) {

            if (entry.getValue() > 0) {

                RoomUC4 room = createRoom(entry.getKey());

                room.display();
                System.out.println("Available: " + entry.getValue());
                System.out.println("----------------------");
            }
        }
    }

    private RoomUC4 createRoom(String type) {

        if (type.equals("Single Room"))
            return new RoomUC4(type, 1, 1000);

        if (type.equals("Double Room"))
            return new RoomUC4(type, 2, 2000);

        return new RoomUC4(type, 3, 5000);
    }
}

// Main Class
public class UC4RoomSearch {

    public static void main(String[] args) {

        RoomInventoryUC4 inventory = new RoomInventoryUC4();
        RoomSearchService service = new RoomSearchService();

        service.search(inventory);
    }
}