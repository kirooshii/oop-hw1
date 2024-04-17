package homeworks.hw1.scooter;

public class ScooterRentalTester {
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
        Scooter rentedScooter = company.rentScooter();  

        // go to the university
        rentedScooter.goTo(41.725363, 44.7753280);

        // return the scooter (we've arrived to the university)
        company.returnScooter(rentedScooter.getId(), rentedScooter.getX(), rentedScooter.getY());
        rentedScooter = null;

        // wait for an hour (5 seconds)
        try {
            Thread.sleep(5000); // 5000 ms = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // rent the available scooter
        rentedScooter = company.rentScooter();

        // go home
        rentedScooter.goTo(41.720913, 44.773304);

        // return the scooter (we've arrived home)
        company.returnScooter(rentedScooter.getId(), rentedScooter.getX(), rentedScooter.getY());
        rentedScooter = null;

        // display info about scooters
        company.displayAllScooters();
    }
}
