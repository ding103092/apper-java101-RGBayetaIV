package zoo.hr;

public class Manager {
    String name;
    int age;
    String title;

    public Manager(String name, int age, String title) {
        this.name = name;
        this.age = age;
        this.title = title;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getTitle() {
        return this.title;
    }

    public void viewEmployeeSalary(Employee employee) {
        // We don't need to create getSalary method
        // If salary is already visible to Manager class
        System.out.println("Employee: " + employee.getName() + " has salary of " + employee.salary);
    }
}
