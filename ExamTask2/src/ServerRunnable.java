import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ServerRunnable implements Runnable{
    Socket client;
    Scanner clientInput;
    PrintStream clientOutput;

    public ServerRunnable(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {
        try {
            clientInput = new Scanner(client.getInputStream());
            clientOutput = new PrintStream(client.getOutputStream());
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        while (true){
            clientOutput.println("Enter a option");
            clientOutput.println("1.Show All Events");
            clientOutput.println("2.Add New Participant");

            int initialChoice = Integer.parseInt(clientInput.nextLine());

            switch (initialChoice){
                case 1:
                    try {
                        AcceptSearch();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    AddParticipant();
                    break;
                default:
                    System.err.println("Error in choice type");
                    break;
            }
        }
    }

    void AcceptSearch() throws IOException {
        clientOutput.println("Enter town");
        String town = clientInput.nextLine();

        clientOutput.println("Enter date");
        String date = clientInput.nextLine();

        List<Event> result = EventTester.ShowAllEvents(town, date);

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Event.ser"));
        for (Event e:result) {
            outputStream.writeObject(e);
            outputStream.flush();
        }
        outputStream.close();
    }

    void AddParticipant(){
        clientOutput.println("Enter id");
        int id = Integer.parseInt(clientInput.nextLine());

        EventTester.addNewParticipant(id);
    }
}
