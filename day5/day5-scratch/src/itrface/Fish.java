package itrface;

public class Fish extends Animal implements ForWaterOnly, NoLeg {
    @Override
    public void swim() {
        System.out.println("The fish can swim");
    }

    @Override
    public void dontWalk() {
        System.out.println("The fish does not walk");
    }


}