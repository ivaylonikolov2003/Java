import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Circle> circles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String radius = scanner.nextLine();
            String color = scanner.nextLine();

            Circle circle = new Circle(radius, color);

            circles.add(circle);
        }

        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("Circle.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for (Circle circle: circles) {
            out.writeObject(circle);
        }
        out.close();
        fileOut.close();

        System.out.println("Objects save to a file!");

    }
}
