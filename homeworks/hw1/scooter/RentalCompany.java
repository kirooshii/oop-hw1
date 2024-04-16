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
    public void rentScooter() {
        boolean rented = false;
        for (Scooter scooter: scooters) {
            // if there is an available scooter, it sets the scooter as rented and prints the details of the rented scooter
            if (scooter.isAvailable()) {
                rented = true;
                scooter.setAvailable(false);
                System.out.println("You've rented: " + scooter.getModel() + "  ID: " + scooter.getId());
                break;
            }
        }
        // if there are no available scooters, it prints a message indicating that no scooters are available.
        if (!rented) {
            System.out.println("Unfortunately, no scooters available");
        }
    }

     // returns a scooter with the specified ID to the rental company
    public void returnScooter(int id) {
        for (Scooter scooter: scooters) {
            // if a scooter with the given ID is found, it is marked as available and prints the details of the returned scooter
            if (scooter.getId() == id) {
                scooter.setAvailable(true);
                System.out.println("You've returned: " + scooter.getModel() + "  ID: " + scooter.getId());
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