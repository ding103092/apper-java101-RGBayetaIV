package zoo.hr;

import zoo.Person;

public class Manager extends Person {
    private String title;

    public Manager(String name, int age,String title) {
        super(name,age);
        this.title = title;
    }

    public String getName() {
        return super.getName();
    }

    public int getAge() {
        return super.getAge();
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
