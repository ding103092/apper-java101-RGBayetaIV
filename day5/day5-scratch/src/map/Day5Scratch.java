package map;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Day5Scratch {
    public static void main(String[] args) {
        Map<String, String> cars = new HashMap<String, String>();
        cars.put("c1","Innova");
        cars.put("c2","Ferrari");
        cars.put("c3","Toyota");
        cars.put("c4","Honda");
        cars.put("c5","Vios");
        cars.put("c6","Tesla");

        System.out.println(cars.get("c4"));
        System.out.println(cars.size());
        System.out.println(cars.keySet());
        System.out.println(cars.containsKey("c7"));
        System.out.println(cars.containsValue("Honda"));
        System.out.println(cars.values());

        // Scanner
        System.out.println("---------");
        Scanner scanner = new Scanner(System.in);
        double nextDouble = scanner.nextDouble();
        System.out.println(nextDouble);
    }
}
