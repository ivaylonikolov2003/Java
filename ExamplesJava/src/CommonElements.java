import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        String[] strings = {"Python", "JAVA", "PHP", "C#", "C++", "SQL"};
        String[] strings1 = {"MySQL", "SQL", "SQLite", "Oracle", "PostgreSQL", "DB2", "JAVA"};

        System.out.println("Array 1:" + Arrays.toString(strings));
        System.out.println("Array 2:" + Arrays.toString(strings1));

        List<String> strings2 = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings1.length; j++) {
                if (strings[i].equals(strings1[j])){
                    strings2.add(strings[i]);
                }
            }
        }
        for (String s:strings2) {
            System.out.println(s);
        }
    }
}
