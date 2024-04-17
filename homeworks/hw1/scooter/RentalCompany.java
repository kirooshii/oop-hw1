package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

public class RentalCompany {

    private int uid = 0;

    // creates a list of scooters in the rental company
    List<Scooter> scooters = new ArrayList<>();
    
    // returns a list of available scooters in the rental company
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    // add scooter to the rental company
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++); // adds an id to the scooter
        scooters.add(scooter);
    }

    // removes a scooter with the specified ID from the rental company
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed; // return True if the scooter was successfully removed, False otherwise
    }
    
    // rents a scooter from the rental company
    public Scooter rentScooter() {
        Scooter rentedScooter = null;
        for (Scooter scooter: scooters) {
            // if there is an available scooter, it sets the scooter as rented and returns it
            if (scooter.isAvailable()) {
                rentedScooter = scooter;
                scooter.setAvailable(false);
                System.out.println("You've rented: " + scooter.getModel() + "  ID: " + scooter.getId() + "  Battery level: " + scooter.getBatteryLevel() + "%");
                break;
            }
        }
        // if there are no available scooters, it prints a message indicating that no scooters are available.
        if (rentedScooter == null) {
            System.out.println("Unfortunately, no scooters available");
        }
        return rentedScooter; // returns the rented scooter with the all information
    }


     // returns a scooter with the specified ID to the rental company
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter: scooters) {
            // if a scooter with the given ID is found, it is marked as available and prints the details of the returned scooter
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                System.out.println("You've returned: " + scooter.getModel() + "  ID: " + scooter.getId() + "  Battery level: " + scooter.getBatteryLevel() + "%");
                System.out.println();
                break;
            }
            // if a scooter with the given ID is not found, it prints a message indicating that the scooter was not found
            else {
                System.out.println("Scooter not found");
            }
        }
    }

    // display all scooters in the rental company
    public void displayAllScooters() {
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }
}