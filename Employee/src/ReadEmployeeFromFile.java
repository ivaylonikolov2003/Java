import java.io.*;

public class ReadEmployeeFromFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Employee.ser"));

        Employee employee = null;

        try {
            while ((employee = (Employee) inputStream.readObject()) != null){
                System.out.println(employee);
            }
        }catch (EOFException e){
            System.out.println("File is empty!");
        }

        inputStream.close();
    }
}
