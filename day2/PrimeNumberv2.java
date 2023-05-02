import java.util.Scanner;

public class PrimeNumberv2 {
    public static void main(String[] args) {
        // Program ask for a number between 2 and 10_000_000
        Scanner myScanner = new Scanner(System.in);
        int num = -1; // Temporary value

        while(num < 0 || num > 10000000) {
            System.out.print("Give me a number from 2 to 10 million: ");
            if (myScanner.hasNextInt()) {
                num = myScanner.nextInt();
                if (num < 0 || num > 10000000) {
                    System.out.println("The number must be within valid range.");
                }
            } else {
                System.out.println("Invalid input.");
                myScanner.next(); // Move on to next input
            }
        }
        // Close the scanner
        myScanner.close();

        // Compute time
        long startTime = System.nanoTime();
        // Check if the number is prime or not using isPrime method
        if (isPrime(num)) {
            System.out.println(num + " is prime.");
        }
        else {
            System.out.println(num + " is not prime.");
        }
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime-startTime));
    }

    public static boolean isPrime(double n) {
        // I used this link as the basis of my answer
        // https://www.youtube.com/watch?v=5CUvf675-6o
        // TLDR: All primes can be expressed in 6k+1 or 6k-1 notation
        // wherein k is an element of the integer values

        /** As you can see in my PrimeNumber.java submission,
         * I searched from the range 2 ... sqrt(N)
         * but the faster method is two search for 2, 3, 4 in advance
         * and start with 5, as explained in the proof at the video
         * So effectively, we are searching for 6k+1 or 6k-1 as a possible
         * factors of number n.
         *
         * 6k = divisible by 2, so not a prime
         * 6k + 1 = might be a prime
         * 6k + 2 = div by 2
         * 6k + 3 = div by 3
         * 6k + 4 = div by 2
         * 6k + 5 = might be a prime
         *
         * So in essence, it's effectively the same with my previous submission
         * with added minor checks
         */

        // Cannot be 1 or less than 1 by definition
        if(n<=1)
            return false;
        // Just flat out say they are both primes
        if(n==2 || n==3)
            return true;
        // Quickly disregards those divisible by 2 and 3
        if(n%2==0 || n%3==0)
            return false;

        // We make sqrt(N) as max as explained in my previous submission
        // we cast it to int as we only care about its floor value
        int sqrtNum = (int) Math.sqrt(n);

        // Actual checker of 6k+-1 notation
        for(int i=5; i<=sqrtNum; i = i + 6) {
            //  6k-1        6k+1
            if (n%i==0 || n%(i+2)==0)
                return false;
        }
        // We use the value i=5, since it's of the form 6k-1, k=1 (6-1=5)
        // The 6k+1 here is 13, we get it by i(5) = 5+6 = 11, then we add 2
        // to make it of the form 6k+1

        return true;
    }
}
