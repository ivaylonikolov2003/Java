import java.util.Scanner;
class SickPatient extends Patient {
    private String epicrisа;
    private boolean isSick;
    private int dayOfIllness;

    public SickPatient(String name, String address, String EGN) {
        super(name, address, EGN);
        epicrisа = "";
        isSick = true;
        dayOfIllness = 0;
    }

    public void cure(String medicine, int dose) {
        epicrisа += "Medicine: " + medicine + ", Dose: " + dose + "\n";
    }

    public void enterInfo() {
        super.enterInfo();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter epicrisа: ");
        epicrisа = input.nextLine();
        System.out.print("Is the patient sick? (true/false): ");
        isSick = input.nextBoolean();
        System.out.print("Enter day of illness: ");
        dayOfIllness = input.nextInt();
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Epicrisа: " + epicrisа);
        System.out.println("Sick: " + isSick);
        System.out.println("Day of Illness: " + dayOfIllness);
    }
}
