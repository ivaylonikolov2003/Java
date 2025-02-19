import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;


    public Student(String firstName, String lastName, int age, String homeTown)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String input = scanner.next();

        while (!input.equals("end"))
        {
           Student student = new Student(input, scanner.next(), scanner.nextInt(), scanner.next());

           Student foundStudent = null;
            for (int i = 0; i < students.size(); i++) {
                Student checkStudent = students.get(i);
                if (checkStudent.getFirstName().equals(student.getFirstName()) && checkStudent.getLastName().equals(student.getLastName()))
                {
                    foundStudent = checkStudent;
                    break;
                }
            }
           if (foundStudent == null) {
               students.add(student);
           }
           else {
               foundStudent.setAge(student.getAge());
               foundStudent.setHomeTown(student.getHomeTown());
           }

           input = scanner.next();
        }

        String cityName = scanner.next();

        for (Student student:students) {
            if (cityName.equals(student.getHomeTown()))
            {
                System.out.printf("%s %s is %d years old.", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }


    }
}
