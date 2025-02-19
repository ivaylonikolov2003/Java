import java.util.HashMap;
import java.util.Scanner;

class Circle1 implements Comparable<Circle1>{
    private int id;
    private double radius;
    private static int count = 0;


    public Circle1(double radius) {
        this.radius = radius;
        this.id = ++count;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Added: Circle #%d (radius=%.2f)", this.id, this.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Circle1))
            return false;
        Circle1 otherCircle = (Circle1) obj;
        return this.radius == otherCircle.radius;
    }

    @Override
    public int compareTo(Circle1 otherCircle) {
        return Double.compare(this.radius, otherCircle.radius);
    }
}
public class CirclesExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Circle1> circles = new HashMap<>();
        while (true){
            String cmdLine = scanner.nextLine();
            if (cmdLine.equals("stop")){
                System.out.println("Goodbye");
                break;
            }
            String[] cmdPart = cmdLine.split(" ");

            if (cmdPart[0].equals("circle")){
                double radius = Double.parseDouble(cmdPart[1]);
                Circle1 circle = new Circle1(radius);
                circles.put(circle.getId(), circle);
                System.out.println(circle);
            }
            else if (cmdPart[0].equals("compare")){
                int c1 = Integer.parseInt(cmdPart[1]);
                int c2 = Integer.parseInt(cmdPart[2]);
                Circle1 circle1 = circles.get(c1);
                Circle1 circle2 = circles.get(c2);
                int compareResult = circle1.compareTo(circle2);
                System.out.printf("Circle #%d %s Circle #%d\n", circle1.getId(), getSign(compareResult), circle2.getId());
            }

        }
    }

    private static String getSign(int compareResult) {
        if (compareResult < 0)
            return "<";
        if (compareResult > 0)
            return ">";
        return "==";
    }


}
