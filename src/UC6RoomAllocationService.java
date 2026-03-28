import java.util.*;

/**
 * UC6: Reservation Confirmation & Room Allocation
 * Version: 6.0
 */

// Reservation
class Reservation {
    String customerName;
    String roomType;

    Reservation(String customerName, String roomType) {
        this.customerName = customerName;
        this.roomType = roomType;
    }
}

// Inventory
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 1);
        inventory.put("Suite Room", 1);
    }

    public int getAvailable(String type) {
        return inventory.getOrDefault(type, 0);
    }

    public void decrease(String type) {
        inventory.put(type, inventory.get(type) - 1);
    }
}

// Booking Service
class BookingService {

    private Set<String> allocatedRooms = new HashSet<>();
    private HashMap<String, Set<String>> roomMap = new HashMap<>();

    public void process(Queue<Reservation> queue, RoomInventory inventory) {

        while (!queue.isEmpty()) {

            Reservation r = queue.poll();

            String type = r.roomType;

            if (inventory.getAvailable(type) > 0) {

                String roomId = generateRoomId(type);

                // ensure unique
                while (allocatedRooms.contains(roomId)) {
                    roomId = generateRoomId(type);
                }

                allocatedRooms.add(roomId);

                roomMap.putIfAbsent(type, new HashSet<>());
                roomMap.get(type).add(roomId);

                inventory.decrease(type);

                System.out.println("Booking Confirmed:");
                System.out.println("Customer: " + r.customerName);
                System.out.println("Room Type: " + type);
                System.out.println("Room ID: " + roomId);
                System.out.println("----------------------");

            } else {
                System.out.println("No rooms available for " + r.customerName);
            }
        }
    }

    private String generateRoomId(String type) {
        return type.substring(0, 2).toUpperCase() + new Random().nextInt(100);
    }
}

// Main
public class UC6RoomAllocationService {

    public static void main(String[] args) {

        // Queue (from UC5)
        Queue<Reservation> queue = new LinkedList<>();

        queue.add(new Reservation("Yash", "Single Room"));
        queue.add(new Reservation("Rahul", "Single Room"));
        queue.add(new Reservation("Amit", "Single Room")); // should fail

        RoomInventory inventory = new RoomInventory();
        BookingService service = new BookingService();

        service.process(queue, inventory);
    }
}