import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateStrings implements Serializable {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            strings.add(text);
        }

        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = i+1; j < strings.size(); j++) {
                if (strings.get(i).equals(strings.get(j)) && (i != j)){
                    System.out.println("Duplicate elements: " + strings.get(j));
                }
            }
        }
        writeToFile(strings);
    }

    public static void writeToFile(List<String> strings)throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("strings.ser"));
        outputStream.writeObject(strings);
        outputStream.flush();
        outputStream.close();
        System.out.println("Successfully write to a file");
    }
}
