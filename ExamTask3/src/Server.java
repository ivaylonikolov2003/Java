import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
    public static final int PORT = 7777;
    public static Map<User, List<String>> usersMap;

    public Server(){
        this.usersMap = new HashMap<>();
    }

    public void start() throws IOException {
        try {
            ServerSocket socket = new ServerSocket(PORT);
            while (true){
                Socket newClient = socket.accept();
                System.out.println("A new client is connected!");
                Thread thread = new Thread(new UserRunnable(newClient));
                thread.start();
            }
        }catch (IOException e){
            System.out.println("Port number is in use!");
        }
    }

    public void loadFromFile(){
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("User.ser"))) {
            usersMap = ((HashMap<User, List<String>>) input.readObject());
        } catch (FileNotFoundException e) {
            saveToFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } ;
    }

    public void saveToFile(){
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("User.ser"))) {
            output.writeObject(usersMap);
            output.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
