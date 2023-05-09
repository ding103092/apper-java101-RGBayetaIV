import java.util.List;
import java.util.ArrayList;
import zoo.animals.Animal;
import zoo.hr.Employee;
import zoo.hr.Manager;
import zoo.visitors.Visitor;

public class Zoo {
    // Main app for zoo package
    private List<Animal> animals;
    private List<Visitor> visitors;
    private List<Employee> employees;
    private List<Manager> managers;

    // Constructor
    public Zoo(){
        this.animals = new ArrayList<>();
        this.visitors = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.managers = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    public void addManager(Manager manager) {
        this.managers.add(manager);
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        // Samples
        zoo.addAnimal(new Animal("Bob","dog","dogfood"));
        Animal myDog = zoo.animals.get(0);
        zoo.animals.get(0).chewFood();

        zoo.addVisitor(new Visitor("Ding",23));
        System.out.println(zoo.visitors.get(0).getName());

        zoo.addEmployee(new Employee("Dong",21020));
        zoo.employees.get(0).feedAnimal(); // No assigned so error!
        Employee temp = zoo.employees.get(0);

        zoo.addManager(new Manager("Redge",31,"Boss"));
        zoo.managers.get(0).viewEmployeeSalary(temp); // 21020

        // Now assign the employee an animal
        temp.setAssignedAnimal(myDog);
        temp.feedAnimal();
    }
}
