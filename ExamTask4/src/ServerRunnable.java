import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerRunnable implements Runnable{
    Socket client;
    Scanner clientInput;
    PrintStream clientOutput;

    public ServerRunnable(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            clientInput = new Scanner(client.getInputStream());
            clientOutput = new PrintStream(client.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        while (true){
            clientOutput.println("Enter a option");
            clientOutput.println("1.Reservation");
            clientOutput.println("2.Rating");

            int initialChoice = Integer.parseInt(clientInput.nextLine());

            switch (initialChoice){
                case 1:
                    Reservation();
                    break;
                case 2:
                    Rating();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public void Reservation(){
        clientOutput.println("Enter your destination");
        String cityDestination = clientInput.nextLine();

        ArrayList<Offert> availableHotels = findHotelByDestination(cityDestination);
        if (availableHotels.isEmpty()){
            clientOutput.println("No hotels available");
        }

        clientOutput.println("Available hotels:");
        for (Offert offert:availableHotels){
            clientOutput.println(offert.offertId + offert.nameOfHotel);
        }

        clientOutput.println("Enter offerId to make a reservation");
        int offerId = Integer.parseInt(clientInput.nextLine());
        Server.users.get(0).grades.add(new Grade(offerId, false));
        clientOutput.println("Reservation successful!");
    }

    public static ArrayList<Offert> findHotelByDestination(String destination){
        ArrayList<Offert> result = new ArrayList<>();
        for (Offert hotel: Server.offerts) {
            if (hotel.destination.equalsIgnoreCase(destination)){
                result.add(hotel);
            }
        }
        return result;
    }

    public void Rating(){
        clientOutput.println("Send OfferId");
        int offerId = Integer.parseInt(clientInput.nextLine());

        Grade userGrade = findUserGrade(Server.users.get(0), offerId);

        if (userGrade != null && !userGrade.evaluation){
            clientOutput.println("Enter your grade(1 to 6)");
            int gradeValue = Integer.parseInt(clientInput.nextLine());

            Server.offerts.get(offerId - 1).evaluation.add(gradeValue);
            recalculatingRating(Server.offerts.get(offerId - 1));

            clientOutput.println("Rating submitted successfully");
        }
        else {
            clientOutput.println("You either haven't made a reservation or already submitted a rating.");
        }
    }

    public static Grade findUserGrade(User user, int offerId){
        for (Grade grade: user.grades) {
            if (grade.offertId == offerId){
                return grade;
            }
        }
        return null;
    }
    public static void recalculatingRating(Offert offert){
        double sum = 0;
        for (int grade: offert.evaluation) {
            sum += grade;
        }
        offert.rating = sum / offert.evaluation.size();
    }
}
