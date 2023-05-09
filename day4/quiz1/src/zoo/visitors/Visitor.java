package zoo.visitors;

public class Visitor {
    private String name;
    private int age;

    public Visitor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // "Age is a secret (private) but it can be retrieved (using getter)
    public int getAge() {
        return this.age;
    }

    // Let's do the same with name
    public String getName() {
        return this.name;
    }

}
