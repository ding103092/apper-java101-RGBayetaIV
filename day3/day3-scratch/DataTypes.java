public class DataTypes {
    static int age;
    static double salary;
    static boolean isHappy;
    static char favoriteLetter;
    static long distance;
    static float weight;
    static Integer x;
    int b; // without  declaring this as static,
    // you cannot call this in main without creating an instance of DataTypes

    public static void main(String[] args) {
        System.out.println(age + " " + x);
        System.out.println(salary);
        System.out.println(isHappy);
        System.out.println(favoriteLetter);
        System.out.println(weight);
        System.out.println(distance);

        // This shows the concept of immutability in Java
        String ax = "Hello World";
        String bx = ax;
        ax = "Caissa";

        System.out.println(ax); // "Caissa"
        System.out.println(bx); // "Hello World"

        // In the background, the value of a is not changed
        // rather a new block of memory that contains "Caissa"
        // is now being reference to a
        // The original value of a will be now disgarded by
        // the garbage collector

        int xd = 40;
        Integer xc = xd;

        // Operators
        int a = 9, b = 10, c = 78;
        System.out.println((a+b)+c%4);
        // modulo same precedence with */

        // c++ uses the same value of c
        // ++c already updates
        System.out.println(c++ + " " + ++c);

    }

}
