import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeProcessor {
    public static void main(String[] args) {
        // Sample dataset
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, "HR", 50000),
                new Employee("Bob", 35, "Engineering", 75000),
                new Employee("Charlie", 32, "Sales", 60000),
                new Employee("David", 45, "Engineering", 80000)
        );

        // Function to concatenate name and department
        Function<Employee, String> nameDeptFunction = emp -> emp.getName() + " - " + emp.getDepartment();

        // Generate new collection with concatenated strings
        List<String> nameDeptList = employees.stream()
                .map(nameDeptFunction)
                .collect(Collectors.toList());

        // Calculate average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        // Filter employees above age threshold
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .collect(Collectors.toList());

        // Output results
        System.out.println("Concatenated Name and Department: " + nameDeptList);
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Filtered Employees: " + filteredEmployees);
    }
}