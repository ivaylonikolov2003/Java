import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehicles = new ArrayList<>();

        while (!"End".equals(input)){
            String[] command = input.split(" ");
            String type = command[0];
            String model = command[1];
            String color = command[2];
            int horsePower = Integer.parseInt(command[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            vehicles.add(vehicle);

            input = scanner.nextLine();

        }

        String model = "";
        while (!"Close the Catalogue".equals(model = scanner.nextLine())){
            String finalModel = model;
            vehicles
                    .stream()
                    .filter(vehicle -> vehicle.getModel().equals(finalModel))
                    .forEach(System.out::println);
        }

        System.out.println(String.format("Cars have average horsepower of: %.2f", average(vehicles.stream()
                .filter(v -> v.getTypeOfVehicle().equals("car"))
                .collect(Collectors.toList()))));

        System.out.println(String.format("Trucks have average horsepower of: %.2f", average(vehicles.stream()
                .filter(v -> v.getTypeOfVehicle().equals("truck"))
                .collect(Collectors.toList()))));
    }

    private static double average(List<Vehicle> vehicles){
        if (vehicles.size() == 0){
            return 0.0;
        }
        double sum = 0;

        for (Vehicle vehicle : vehicles){
            sum += vehicle.getHorsePower();
        }

        return sum / vehicles.size();
    }
}
