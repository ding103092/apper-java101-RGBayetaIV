package oop.app;

import oop.app.blueprint.Person;

public class App {
    public static void main(String[] args) {
        Person ding = new Person();
        ding.setName("Ding");
        ding.setAge(23);

        ding.introducePerson();
    }
}
