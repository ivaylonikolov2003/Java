import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<RawData> carList = new ArrayList<>();

        RawData car;
        Engine engine;
        Cargo cargo;
        Tires tire1;
        Tires tire2;
        Tires tire3;
        Tires tire4;

        for (int i = 0; i < n; i++) {
            String[] cmdParts = scanner.nextLine().split(" ");
            String model = cmdParts[0];
            int engSpeed = Integer.parseInt(cmdParts[1]);
            int engPower = Integer.parseInt(cmdParts[2]);

            int cargoWeight = Integer.parseInt(cmdParts[3]);
            String cargoType = cmdParts[4];

            double tire1Pressure = Double.parseDouble(cmdParts[5]);
            int tire1Age = Integer.parseInt(cmdParts[6]);
            double tire2Pressure = Double.parseDouble(cmdParts[7]);
            int tire2Age = Integer.parseInt(cmdParts[8]);
            double tire3Pressure = Double.parseDouble(cmdParts[9]);
            int tire3Age = Integer.parseInt(cmdParts[10]);
            double tire4Pressure = Double.parseDouble(cmdParts[11]);
            int tire4Age = Integer.parseInt(cmdParts[12]);

            engine = new Engine(engSpeed, engPower);
            cargo = new Cargo(cargoWeight, cargoType);
            tire1 = new Tires(tire1Pressure, tire1Age);
            tire2 = new Tires(tire2Pressure, tire2Age);
            tire3 = new Tires(tire3Pressure, tire3Age);
            tire4 = new Tires(tire4Pressure, tire4Age);

            car = new RawData(model, engine, cargo, tire1, tire2, tire3, tire4);
            carList.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")){
            carList.forEach(item -> {
                if (item.getCargo().getType().equals("fragile") && item.getTires().get(0).getTirePressure() < 1){
                    System.out.println(item);
                }
            });
        }
        if (command.equals("flamable")){
            carList.forEach(item -> {
                if (item.getCargo().getType().equals("flamable") && item.getEngine().getPower() > 250) {
                    System.out.println(item);
                }
            });
        }
    }
}
