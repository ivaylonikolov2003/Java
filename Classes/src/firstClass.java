import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class firstClass {
    static class Student {
        String name;
        int id;
        double avgGrade;

        String asString() {

            return String.format("%s (%d) - %f%n", name, id, avgGrade);

        }

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < studentsCount; i++) {
            String name = scanner.nextLine();
            int id = Integer.parseInt(scanner.nextLine());
            double avgGrade = Double.parseDouble(scanner.nextLine());

            Student student = new Student();
            student.name = name;
            student.id = id;
            student.avgGrade = avgGrade;

            students.add(student);
        }

        int index = 0;
        while (index < students.size()) {
            if(students.get(index).name.isEmpty())
            {
                students.remove(index);
            }
            else
            {
                index++;
            }
        }


        for (Student student: students) {
            System.out.printf(student.asString());
        }
    }
}
