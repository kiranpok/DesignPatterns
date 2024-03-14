package Assignment3_Composite;

// Client class demonstrating the functionality
public class Main {
    public static void main(String[] args) {
        // Create the organizational structure
        Department engineering = new Department("Engineering");
        Department marketing = new Department("Marketing");
        Department sales = new Department("Sales");

        Employee kiran = new Employee("Kiran POkharel", 50000);
        Employee bhuwan = new Employee("Bhuwan Pokharel", 60000);
        Employee evan = new Employee("Evan Pokharel", 70000);
        Employee aava = new Employee("Aava Pokharel", 55000);

        engineering.addSubUnit(kiran);
        marketing.addSubUnit(bhuwan);
        marketing.addSubUnit(evan);
        sales.addSubUnit(aava);

        engineering.addSubUnit(marketing);
        engineering.addSubUnit(sales);

        // Print the organizational structure
        System.out.println("Organizational Structure:");
        engineering.print();

        // Print the total salary of the organization
        double totalSalary = engineering.getSalary();
        System.out.println("\nTotal Organization Salary: $" + totalSalary);

        // Print the organizational structure in XML format
        System.out.println("\nOrganizational Structure in XML:");
        System.out.println("<Organization>");
        printXmlFormat(engineering, 1);
        System.out.println("</Organization>");
    }

    private static void printXmlFormat(OrganizationalUnit unit, int depth) {
        String indentation = " ".repeat(depth * 4);

        if (unit instanceof Department) {
            System.out.println(indentation + "<Department name=\"" + unit.toString() + "\">");
            for (OrganizationalUnit subUnit : ((Department) unit).subUnits) {
                printXmlFormat(subUnit, depth + 1);
            }
            System.out.println(indentation + "</Department>");
        } else if (unit instanceof Employee) {
            System.out.println(indentation + "    <Employee name=\"" + ((Employee) unit).toString() +
                    "\" salary=\"" + ((Employee) unit).getSalary() + "\" />");
        }
    }
}


