package FinalAssignment;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDatabase {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Harshit", "IT", 65000),
                new Employee(2, "Aman", "IT", 45000),
                new Employee(3, "abc", "Finance", 60000),
                new Employee(3, "xyz", "HR", 40000)
    );
    
        // Task 1: Salary Greater Than 50000
        System.out.println("Task 1: Employees with salary > 50000:");
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .map(Employee::getName)
                .forEach(System.out::println);

        // Task 2: Salary Increments (10%)
        System.out.println("\nTask 2: Employees with a 10% salary increment:");
        List<Employee> updatedSalaries = employees.stream()
                .map(e -> {
                    e.setSalary(e.getSalary() * 1.10); 
                    return e;
                })
                .collect(Collectors.toList());
        updatedSalaries.forEach(System.out::println);

        // Task 3: Highest Salary Employee
        System.out.println("\nTask 3: Employee with the highest salary:");
        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);

        // Task 4: Count Employees in a Specific Department ("HR")
        System.out.println("\nTask 4: Number of employees in HR department:");
        long hrCount = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                .count();
        System.out.println("HR Count: " + hrCount);

        // Task 5: Group Employees by Department
        System.out.println("\nTask 5: Group employees by department:");
        Map<String, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDept.forEach((department, empList) -> {
            System.out.println(department + ":");
            empList.forEach(System.out::println);
        });

        // Task 6: Get the Average Salary of Employees
        System.out.println("\nTask 6: Average salary of employees:");
        employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .ifPresent(avg -> System.out.println("Average Salary: " + avg));

        // Task 7: Get a List of Employee Names
        System.out.println("\nTask 7: List of employee names:");
        List<String> employeeNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        employeeNames.forEach(System.out::println);

        // Task 8: Check if All Employees Have a Salary Greater Than a Given Value (30000)
        System.out.println("\nTask 8: Do all employees have a salary > 30000?");
        boolean allHighSalary = employees.stream()
                .allMatch(e -> e.getSalary() > 30000);
        System.out.println("All employees have salary > 30000: " + allHighSalary);

        // Task 9: Get the First Employee in the List
        System.out.println("\nTask 9: First employee in the list:");
        employees.stream()
                .findFirst()
                .ifPresent(System.out::println);

        // Task 10: Sort Employees by Salary in Descending Order
        System.out.println("\nTask 10: Employees sorted by salary (descending order):");
        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        sortedBySalary.forEach(System.out::println);
    }

}
