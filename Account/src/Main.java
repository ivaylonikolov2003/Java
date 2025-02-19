import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Account> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String id  = scanner.nextLine();
            String name = scanner.nextLine();
            int balance = Integer.parseInt(scanner.nextLine());

            Account account = new Account(id, name, balance);

            accounts.add(account);
        }

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Account.ser"));
        for (Account account:accounts) {
            outputStream.writeObject(account);
        }
        outputStream.close();

        System.out.println("Accounts are successfully saved");


    }
}
