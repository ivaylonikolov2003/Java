import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static final int PORT = 1234;
    public static ArrayList<Offert> offerts;
    public static ArrayList<User> users;

    public void start(){
        try {
            ServerSocket socket = new ServerSocket(PORT);
            while (true){
                Socket newClient = socket.accept();
                System.out.println("A new client is connected");
                Thread thread = new Thread(new ServerRunnable(newClient));
                thread.start();
            }
        }catch (IOException e){
            System.out.println("Port number is in use");
        }
    }
}
