package map;

import java.util.Map;
import java.util.HashMap;
public class Day5Scratch {
    public static void main(String[] args) {
        Map<String, String> cars = new HashMap<String, String>();
        cars.put("c1","Innova");
        cars.put("c2","Ferrari");
        cars.put("c3","Toyota");
        cars.put("c4","Honda");
        cars.put("c5","Vios");
        cars.put("c6","Tesla");

        System.out.println(cars.size());
        System.out.println(cars.keySet());
        System.out.println(cars.containsKey("c7"));
    }
}
