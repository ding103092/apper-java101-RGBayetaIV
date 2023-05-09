package zoo.hr;
import zoo.Person;
import zoo.animals.Animal;
public class Employee extends Person {
    protected double salary;
    private Animal assignedAnimal;

    public Employee(String name, int age,double salary) {
        super(name, age);
        this.salary = salary;
    }

    public String getName() {
        return super.getName();
    }

    // Feed an animal assigned to him
    public void feedAnimal() {
        // No additional instructions
        // so own interpretation
        if(assignedAnimal != null)
        {
            System.out.println("Employee " + super.getName() + " is now feeding " + assignedAnimal.getName() + " with " + assignedAnimal.getFood());
        }
        else {
            System.out.println("No assigned animal to feed.");
        }
    }

    // Assign an animal to employee
    public void setAssignedAnimal(Animal animal) {
        this.assignedAnimal = animal;
    }

}
