import java.io.*;
import java.util.ArrayList;

public class ReadFromCircle {
    public static void main(String[] args) throws Exception {

        FileInputStream fileIn = new FileInputStream("Circle.ser");
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        Circle circle = null;

        try {
            while ((circle = (Circle) objIn.readObject()) != null){
                System.out.println(circle);
            }
        }catch (EOFException e){
            System.out.println("File is empty!");
        }

        objIn.close();
        fileIn.close();

    }
}
