import java.util.Scanner;
abstract class Patient {
    private String name;
    private String address;
    private String EGN;

    public Patient(String name, String address, String EGN) {
        this.name = name;
        this.address = address;
        this.EGN = EGN;
    }

    public void enterInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter address: ");
        address = input.nextLine();
        System.out.print("Enter EGN: ");
        EGN = input.nextLine();
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("EGN: " + EGN);
    }

    public abstract void cure(String medicine, int dose);
}
