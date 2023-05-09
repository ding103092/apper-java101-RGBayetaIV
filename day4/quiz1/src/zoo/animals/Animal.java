package zoo.animals;

public class Animal {
    private String name;
    private String type;
    private String food;

    public Animal(String name, String type, String food) {
        this.name = name;
        this.type = type;
        this.food = food;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getFood() {
        return this.food;
    }


    // My interpretation of "produces own sound"
    public String getSound() {
        switch (this.type) {
            case "dog":
                return "Woof";
            case "cat":
                return "Meow";
            case "cow":
                return "Moo";
            case "sheep":
                return "Baa";
            default:
                return "Unknown sound.";
        }
    }

    // I am not sure how to implement this
    // For review later
    public void chewFood() {
        System.out.println(this.name + " is chewing " + this.food);
    }
}
