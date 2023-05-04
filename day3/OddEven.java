public class OddEven {
    public static void main(String[] args) {
        // Declare array nums
        int[] nums = new int[]{1, 234, 2, 4, 56, 17, 50, 1235, 6, 1, 23, 48, 47, 34};

        // Odd and Even counter
        int oddCtr = 0, evenCtr = 0;

        // Iterate the numbers from nums and count the odd and even numbers
        for(int num : nums) {
            if(isEven(num)) evenCtr++;
            else            oddCtr++;
        }

        // Display results
        System.out.println("Odd: " + oddCtr);
        System.out.println("Even: " + evenCtr);
    }

    // Function that returns if a number is even or not
   public static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
