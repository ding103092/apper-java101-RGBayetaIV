import java.util.Scanner;
import java.util.Random;

class FlamesHope {

    public static void main(String[] args) {
        System.out.println("Welcome to FlamesHope!");

        Scanner myScanner = new Scanner(System.in);

        // Allow user to enter his/her name
        System.out.println("What is your name: ");
        String name = myScanner.nextLine();

        // Check if name is not empty, otherwise display "Your name is required" and
        // the program would terminate
        if (name.isEmpty()) {
            System.out.println("Your name is required");
            System.exit(0);
        }

        // Allow user to enter his/her crush's name 
        System.out.println("What's your crush's name: ");
        String crushName = myScanner.nextLine();

        // Check if crushName is not empty, otherwise display "Your crush's name is required" and
        // the program would terminate
        if (crushName.isEmpty()) {
            System.out.println("Your crush's name is required");
            System.exit(0);
        }

        // Length of name
        int nameLength = name.length();
        // Length of crushName
        int crushNameLength = crushName.length();
        int result = result(nameLength, crushNameLength);

        // Display result
        System.out.println("You compatibility result: " + result);

        // If result is less than 50, display "SAD" other wise display name and crushName is <3
        if (result < 50) {
            System.out.println("SAD");
        } 
        else {
            System.out.println(name + " and " + crushName + " is <3");
        }

        myScanner.close();
    }
static int result(int nameLength, int crushNameLength) {
    int total = nameLength + crushNameLength;
    Random random = new Random();
    return random.nextInt(total - 1) + 1;
}
}

