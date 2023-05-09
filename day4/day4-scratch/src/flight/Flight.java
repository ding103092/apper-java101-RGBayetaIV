package flight;

public class Flight {
    // Fields
    int passengers;
    int seats;

    // Constructors
    Flight(int passengers, int seats) {
        this.passengers = passengers;
        this.seats = seats;
    }

    Flight() {
        this.seats = 10;
        this.passengers = 0;
    }

    // Methods
    public void addPassenger() {
        // Previously !=0, but for best practice, should be >0
        if(this.seats > 0) {
            this.passengers++;
            this.seats--;
            // The ultimate debugger
            // System.out.println(passengers + " " + this.seats);
        }
        else {
            System.out.println("FULL!");
        }
    }

    public void setNumberOfSeats(int seats) {
        if(seats <= this.seats) {
            System.out.println("Cannot allow seat numbers to be less or equal than current capacity.");
        }
        else {
            this.seats = seats - passengers;
        }
    }
}
