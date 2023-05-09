package flight;

public class App {
    public static void main(String[] args) {
        Flight manilaToBoracay = new Flight();

        for(int i = 0; i<10; i++) {
            manilaToBoracay.addPassenger();
        }

        System.out.println("Current # of seats: " + manilaToBoracay.seats); // 7
        System.out.println("Current # of passengers: " + manilaToBoracay.passengers); // 13

        // Expected error message
        manilaToBoracay.addPassenger();

        // Now set to 20
        manilaToBoracay.setNumberOfSeats(20);


        for(int i = 0; i<3; i++) {
            manilaToBoracay.addPassenger();
        }

        // Try setting seat to less
        manilaToBoracay.setNumberOfSeats(5);

        System.out.println("Current # of seats: " + manilaToBoracay.seats); // 7
        System.out.println("Current # of passengers: " + manilaToBoracay.passengers); // 13

    }
}
