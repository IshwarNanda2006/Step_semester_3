package classes_objects.assigment_problems;

public class Week6_P5_EmployeeCompanyInformationManagement {

    static class Employee {
        String empName;
        double salary;
        static String companyName =
            "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        new Employee("Aisha", 50000);
        new Employee("Rohit", 60000);
        new Employee("Karan", 55000);

        System.out.println("3 Employee objects created");
        Employee.printCompanyInfo();
    }
}
