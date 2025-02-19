import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int number = Integer.parseInt(scanner.nextLine());

        switch (number)
        {
            case 1:
                System.out.println(dayOfWeek[0]);
                break;
            case 2:
                System.out.println(dayOfWeek[1]);
                break;
            case 3:
                System.out.println(dayOfWeek[2]);
                break;
            case 4:
                System.out.println(dayOfWeek[3]);
                break;
            case 5:
                System.out.println(dayOfWeek[4]);
                break;
            case 6:
                System.out.println(dayOfWeek[5]);
                break;
            case 7:
                System.out.println(dayOfWeek[6]);
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }
}
