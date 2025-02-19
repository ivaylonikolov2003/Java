import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        int number;
        Socket s = new Socket("localhost", 1234);
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(s.getInputStream());
        PrintStream printout = new PrintStream(s.getOutputStream());
        System.out.println("Enter Some Value");

        try {
            number = scan.nextInt();
            printout.println(number);
            String input = scan2.nextLine();
            System.out.println(input);
        }catch (InputMismatchException e){
            System.out.println("Enter correct value");
        }finally {
            if (s != null){
                s.close();
            }
            if (scan != null){
                scan.close();
            }
            if (scan2 != null){
                scan2.close();
            }
        }
    }
}
