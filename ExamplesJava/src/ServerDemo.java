import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        int number;
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        Scanner scan = new Scanner(socket.getInputStream());
        number = scan.nextInt();
        PrintStream printout = new PrintStream(socket.getOutputStream());

        if (number % 2 == 0){
            printout.println("your number is even");
        }else {
            printout.println("your number is odd");
        }

        serverSocket.close();
        scan.close();
    }
}
