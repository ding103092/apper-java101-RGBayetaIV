public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Variables
        int age = 15;

        // Print the age
        System.out.println(age);

        age = age + 10;
        System.out.println(age);

        long balance = 1000000000;
        int newbal = (int) balance + age;
        System.out.println(newbal);

        // decimal
        double price = 4.45;
        double newprice = price + age;
        System.out.println(newprice);

        float discount = 9.56f;
        double subtotal = newprice + discount;
        System.out.println(subtotal);

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        long c = (long)a + (long)b;
        System.out.println(c);

        String name = "Orvyl";
        // name += " King";
        String nname = name.substring(name.indexOf('v'));
        System.out.println(nname);

        noArguments();
        withArguments("Ding");
    }

    public static void noArguments() {
        System.out.println("Line called from noArguments");
    }

    public static void withArguments(String name) {
        System.out.println("I am accepting " + name + " as an argument to function withArguments");
    }
}