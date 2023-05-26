package itrface;

public class Cat extends Animal implements HasLegs {
    @Override
    public void crawl() {
        System.out.println("The cat can crawl");
    }

    @Override
    public void jump() {
        System.out.println("The can can jump");
    }
}