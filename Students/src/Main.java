import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String firstName = line[0];
            String lastName = line[1];
            double grade = Double.parseDouble(line[2]);

            Student student = new Student(firstName, lastName, grade);

            students.add(student);
        }

        List<Student> sortedList = students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());

        for (Student student: sortedList) {
            System.out.println(student);
        }

    }
}
