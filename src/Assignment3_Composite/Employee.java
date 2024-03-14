package Assignment3_Composite;

// Leaf class representing an employee
class Employee implements OrganizationalUnit {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void print() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }

    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return name;
    }
}
