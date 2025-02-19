import java.io.*;

public class Main {
    public static void main(String[] args) {
        User user = new User();

        user.name = "Bro Code";
        user.password = "password123";

        try {
            FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Object info saved!");
    }
}
