package zoo.visitors;

import zoo.Person;

public class Visitor extends Person {

    public Visitor(String name, int age) {
        super(name, age);
    }

    // "Age is a secret (private) but it can be retrieved (using getter)
    public int getAge() {
        return super.getAge();
    }

    // Let's do the same with name
    public String getName() {
        return super.getName();
    }

}
