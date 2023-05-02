public class OddEvenNumbers {
    public static void main(String[] args) {
        System.out.println(isEven(6));
        System.out.println(isEven(7));
    }

    public static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
