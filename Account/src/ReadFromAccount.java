import java.io.*;

public class ReadFromAccount {
    public static void main(String[] args) throws IOException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Account.ser"));
        Account account = null;

        try{
            while ((account = (Account) inputStream.readObject()) != null){
                System.out.println(account);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (EOFException e){
            System.out.println("File is empty!");
        }
        inputStream.close();
    }
}
