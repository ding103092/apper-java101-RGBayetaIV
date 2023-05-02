import java.util.Arrays;

public class Loop {
    public static void main(String[] args) {
        int ctr = 0;
        // while loop
        while(ctr<10) {
            System.out.println(ctr);
            ctr = ctr + 1;
        }
        ctr = 0;
        // do while
        do {
            System.out.println(ctr);
            ctr = ctr + 1;
        } while (ctr<10);
        // for loop
        for(int i = 1; i<=ctr; i++) {
            System.out.println(i);
        }

        // Difference between ctr++ and ++ctr
        int ctr2 = 0;
        int postIncrement = ctr2++;
        int preIncrement = ++ctr2;
        System.out.println(postIncrement + " " + preIncrement);

        // In an array
        int[] arr = {1,2,3,4,5};
        int postSum = 0;
        int preSum = 0;

        // Before
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {
            postSum += arr[i]++; // just like before
            // but now arr values will be appended by 1
            // this will be used to the next for loop
        }
        System.out.println(postSum); // uses original values
        System.out.println(Arrays.toString(arr)); // now the appended values

        for(int i = 0; i < arr.length; i++) {
            preSum += ++arr[i]; // in this append happens before adding to preSum
            // it's a simultaneous method
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(preSum);


    }
}
