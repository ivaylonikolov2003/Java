import java.util.Scanner;

public class UserValidationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[10];

        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                try {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Input password: ");
                    String password = scanner.nextLine();
                    System.out.print("Repeat password: ");
                    String confirmPassword = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();

                    if (!password.equals(confirmPassword)) {
                        System.out.println("Passwords doesn't match.");
                        continue;
                    }

                    User user = new User(username, password, phoneNumber);
                    for (int i = 0; i < users.length; i++) {
                        if (users[i] == null) {
                            users[i] = user;
                            System.out.println("Registration was successful.");
                            break;
                        }
                    }
                } catch (WrongUserException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (WrongPhoneNumberException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                boolean loggedIn = false;
                for (User user : users) {
                    if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        System.out.println("You have successfully logged in as a user " + username);
                        loggedIn = true;
                        break;
                    }
                }

                if (!loggedIn) {
                    System.out.println("Wrong username or password.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid selection. Please, try again.");
            }
        }
    }
}