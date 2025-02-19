import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter car brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();
        System.out.print("Enter car horsePower: ");
        String hp = scanner.nextLine();

        Car car;

        if (hp.equals("")){
            car = new Car(brand, model);
        }
        else
        {
            car = new Car(brand, model, Integer.parseInt(hp));
        }


        System.out.println(car);
    }
}
