package Assignment3_Composite;

import java.util.ArrayList;
import java.util.List;

// Composite class representing a department
class Department implements OrganizationalUnit {
    private String name;
    List<OrganizationalUnit> subUnits = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addSubUnit(OrganizationalUnit unit) {
        subUnits.add(unit);
    }

    public void removeSubUnit(OrganizationalUnit unit) {
        subUnits.remove(unit);
    }

    @Override
    public void print() {
        System.out.println("Department: " + name);
        for (OrganizationalUnit unit : subUnits) {
            unit.print();
        }
    }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationalUnit unit : subUnits) {
            totalSalary += unit.getSalary();
        }
        return totalSalary;
    }
    @Override
    public String toString() {
        return name;
    }
}

