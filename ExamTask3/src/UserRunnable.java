import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class UserRunnable implements Runnable {
    Socket client;
    Scanner clientInput;
    PrintStream clientOutput;
    static final Object mutexLock = new Object();
    User loggedUser;

    public UserRunnable(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            clientInput = new Scanner(client.getInputStream());
            clientOutput = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            clientOutput.println("Enter a option");
            clientOutput.println("1.User registration");
            clientOutput.println("2.Sign in existing account");

            int initialChoice = Integer.parseInt(clientInput.nextLine());

            switch (initialChoice) {
                case 1:
                    try {
                        Registration();
                    } catch (UserException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    try {
                        Sign();
                    } catch (UserException | IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("Enter valid choice!");
                    break;
            }
        }
    }

    public User Registration() throws UserException {
        clientOutput.println("Enter a username");
        String username = clientInput.nextLine();

        clientOutput.println("Enter a password");
        String password = clientInput.nextLine();

        User user = new User(username, password);

        return user;
    }

    public void Sign() throws UserException, IOException {
        clientOutput.println("Enter a username");
        String username = clientInput.nextLine();

        clientOutput.println("Enter a password");
        String password = clientInput.nextLine();

        for (User user : Server.usersMap.keySet()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedUser = user;
                clientOutput.println("Enter a option");
                clientOutput.println("1.Download");
                clientOutput.println("2.Upload");

                int choice = Integer.parseInt(clientInput.nextLine());

                switch (choice) {
                    case 1:
                        Download("User.txt");
                        break;
                    case 2:
                        Upload();
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }

    }

    public void Download(String filename) throws FileNotFoundException {
        synchronized (mutexLock) {
            List<String> fileNames = Server.usersMap.get(loggedUser);

            for (String name : fileNames) {
                if (name.equals(filename)) {
                    File myObj = new File(name);
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        clientOutput.println(data);
                    }
                    myReader.close();
                }
            }
        }
    }

    public void Upload() throws IOException {
        clientOutput.println("Enter filename");
        String filename = clientInput.nextLine();

        clientOutput.println("Enter text");
        String text = clientInput.nextLine();

        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);

        List<String> fileNames = Server.usersMap.get(loggedUser);
        boolean difference = false;
        for (int i = 0; i < fileNames.size(); i++) {
            if (text.getBytes().length == fileInputStream.readAllBytes().length) {
                for (int j = 0; j < fileInputStream.readAllBytes().length; j++) {
                    if (fileInputStream.readAllBytes()[i] != text.getBytes()[i]) {
                        difference = true;
                        break;
                    }
                }

                if (!difference) {
                    break;
                }
            }
        }
        if (difference){
            clientOutput.println("Such a file already exists!");
        }else
        {
            File file1 = new File(filename);
            FileWriter writer = new FileWriter(file1);

            writer.write(text);
        }

    }
}
