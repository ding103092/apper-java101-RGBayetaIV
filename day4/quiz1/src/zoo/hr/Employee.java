package zoo.hr;
import zoo.animals.Animal;
public class Employee {
    private String name;
    protected double salary;
    private Animal assignedAnimal;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    // Feed an animal assigned to him
    public void feedAnimal() {
        // No additional instructions
        // so own interpretation
        if(assignedAnimal != null)
        {
            System.out.println("HR.Employee " + name + " is now feeding " + assignedAnimal.getName() + "with " + assignedAnimal.getFood());
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
