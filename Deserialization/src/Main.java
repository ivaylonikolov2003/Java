import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = null;
        FileInputStream fileInput = new FileInputStream("UserInfo.ser");
        ObjectInputStream input = new ObjectInputStream(fileInput);
        user = (User) input.readObject();
        input.close();
        fileInput.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();

    }
}
