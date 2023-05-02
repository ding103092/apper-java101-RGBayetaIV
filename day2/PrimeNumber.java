import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Prompt an interger from the user using myScanner
        System.out.print("Enter the number: ");
        int num = myScanner.nextInt();

        // Close the scanner
        myScanner.close();

        // Check if the number is prime or not using isPrime method
        if (isPrime(num)) {
            System.out.println(num + " is prime.");
        }
        else {
            System.out.println(num + " is not prime.");
        }
        
    }

    public static boolean isPrime(int n) {
        // Prime numbers, according to google are
        // whole number greater than 1 that cannot be exactly
        // divided by any whole number other than itself

        // Values <= 1 are already non-prime numbers
        if (n <= 1) {
            return false;
        }

        // Checks for the possible factors from range 2 and sqrt(n)
        // We only check until sqrt(n) because if n is a composite number,
        // It can be factored into n = a * b, wherein a,b are less than sqrt(n)
        // It cannot go beyond the upper bound sqrt(n) at that point
        // because if sqrt(n) is an integer, it is not a prime number
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
