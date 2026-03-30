import java.util.*;

/**
 * UC7: Add-On Service Selection
 * Version: 7.0
 */

// Service class
class Service {
    String name;
    double price;

    Service(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Manager class
class AddOnServiceManager {

    private Map<String, List<Service>> serviceMap = new HashMap<>();

    // Add service to reservation
    public void addService(String reservationId, Service service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Added " + service.name + " to " + reservationId);
    }

    // Show services
    public void showServices(String reservationId) {

        List<Service> services = serviceMap.get(reservationId);

        if (services == null) {
            System.out.println("No services for " + reservationId);
            return;
        }

        double total = 0;

        System.out.println("\nServices for " + reservationId + ":");

        for (Service s : services) {
            System.out.println(s.name + " - " + s.price);
            total += s.price;
        }

        System.out.println("Total Add-On Cost: " + total);
    }
}

// Main
public class UC7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String resId = "R101";

        // Add services
        manager.addService(resId, new Service("Breakfast", 200));
        manager.addService(resId, new Service("WiFi", 100));
        manager.addService(resId, new Service("Spa", 500));

        // Show services
        manager.showServices(resId);
    }
}