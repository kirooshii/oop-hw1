package homeworks.hw1.scooter;

public class Tester {
    public static void main(String[] args) {

        // create the rental company
        RentalCompany company = new RentalCompany();

        // create the scooters
        Scooter scooter1 = new Scooter();
        scooter1.setModel("Ninebot G30");
        scooter1.setBatteryLevel(100);
        scooter1.setAvailable(true);

        Scooter scooter2 = new Scooter();
        scooter2.setModel("Mankeel MK600");
        scooter2.setBatteryLevel(100);
        scooter2.setAvailable(true);

        // add the scooters to the company.
        company.addScooter(scooter1);
        company.addScooter(scooter2);
   
        // rent the available scooter
        company.rentScooter(); // return true
        company.rentScooter(); // return true
        company.rentScooter(); // return false (because no scooters available)

        // return the scooter
        company.returnScooter(0);

        // display info about scooters
        company.displayAllScooters();
    }
}
