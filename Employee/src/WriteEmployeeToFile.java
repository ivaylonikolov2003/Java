import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WriteEmployeeToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee id: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter salary: ");
            int salary = Integer.parseInt(scanner.nextLine());

            Employee employee = new Employee(id, firstName, lastName, salary);

            employees.add(employee);
        }

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Employee.ser"));
        for (Employee person:employees) {
            outputStream.writeObject(person);
        }
        outputStream.close();

        System.out.println("Objects are successfully written to a file");

    }
}
