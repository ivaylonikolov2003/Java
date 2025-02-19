public class Main {
    public static void main(String[] args) {
        SickPatient patient = new SickPatient("Lucho", "Filipovci", "1234567890");
        patient.enterInfo();
        patient.cure("Paracetamol", 2);
        patient.displayInfo();
    }
}