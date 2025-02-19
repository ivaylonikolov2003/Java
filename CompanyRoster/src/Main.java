import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Employee employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);

            if (input.length == 6) {
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            }
            else if (input.length == 5 && input[4].contains("@")){
                employee.setEmail(input[4]);
                employee.setAge(-1);
                }
            else if (input.length == 5) {
                employee.setEmail("n/a");
                employee.setAge(Integer.parseInt(input[4]));
            }
            else {
                employee.setEmail("n/a");
                employee.setAge(-1);
            }
            employeeList.add(employee);
        }
        List<String> uniqueDepartments = employeeList
                .stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());

        List<Departament> departamentList = new ArrayList<>();

        for (String X: uniqueDepartments) {
            double salary = 0;
            int count = 0;
            for (Employee Y : employeeList){
                if (Y.getDepartment().equals(X)){
                    salary += Y.getSalary();
                    count++;
                }
            }
            Departament department = new Departament(X, salary / count);
            departamentList.add(department);
        }

        departamentList = departamentList.stream()
                .sorted(Comparator.comparing(Departament::getAvgSalary).reversed())
                .collect(Collectors.toList());

        employeeList = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.printf("Highest Average Salary: %s%n", departamentList.get(0).depName);
        for (Employee X:employeeList) {
            if (X.getDepartment().equals(departamentList.get(0).depName)){
                System.out.printf(X.toString() + "%n");
            }
        }
    }
}
