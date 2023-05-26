package itrface;

public class App {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.breath();

        Fish fish = new Fish();
        fish.breath();

        ForWaterOnly a = new Fish();
    }
}