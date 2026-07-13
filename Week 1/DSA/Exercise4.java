public class Exercise4 {

    // Employee Class
    static class Employee {

        int employeeId;
        String name;
        String position;
        double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public void display() {
            System.out.println("Employee ID : " + employeeId);
            System.out.println("Name        : " + name);
            System.out.println("Position    : " + position);
            System.out.println("Salary      : " + salary);
        }
    }

    // Array to store employee records
    static Employee[] employees = new Employee[10];
    static int count = 0;

    // Method to Add Employee
    public static void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count] = emp;
            count++;
            System.out.println("Employee Added Successfully.");
        } else {
            System.out.println("Employee Array is Full.");
        }
    }

    // Method to Search Employee
    public static Employee searchEmployee(int id) {

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }

        return null;
    }

    // Method to Traverse Employees
    public static void traverseEmployees() {

        if (count == 0) {
            System.out.println("No Employee Records Found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            employees[i].display();
            System.out.println("-------------------------");
        }
    }

    // Method to Delete Employee
    public static void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted Successfully.");
    }

    // Main Method
    public static void main(String[] args) {

        // Adding Employees
        addEmployee(new Employee(101, "Rahul", "Manager", 70000));
        addEmployee(new Employee(102, "Priya", "Developer", 55000));
        addEmployee(new Employee(103, "Amit", "Tester", 45000));

        // Display All Employees
        System.out.println("\n===== Employee Records =====");
        traverseEmployees();

        // Search Employee
        System.out.println("\n===== Search Employee =====");
        Employee emp = searchEmployee(102);

        if (emp != null) {
            System.out.println("Employee Found:");
            emp.display();
        } else {
            System.out.println("Employee Not Found.");
        }

        // Delete Employee
        System.out.println("\n===== Delete Employee =====");
        deleteEmployee(102);

        // Display Employees After Deletion
        System.out.println("\n===== Employee Records After Deletion =====");
        traverseEmployees();
    }
}