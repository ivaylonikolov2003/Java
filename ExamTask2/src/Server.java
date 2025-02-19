import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 7777;

    public void start() throws IOException {
        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                Socket newClient = serverSocket.accept();
                System.out.println("A new client is connected!");
                Thread thread = new Thread(new ServerRunnable(newClient));
                thread.start();
            }
        }catch (IOException e){
            System.out.println("Port number is in use");
        }

    }
}
