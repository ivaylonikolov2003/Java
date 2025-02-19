import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class DuplicateElements implements Serializable {
    public static void main(String[] args) throws Exception {
        int[] myArray = {0, 3, -2, 4, 3, 2};

        int arrayLength = myArray.length;
        for (int i = 0; i < arrayLength; i++) {
            for (int j = i+1; j < arrayLength; j++) {
                if (myArray[i] == myArray[j]){
                    myArray[j] = myArray[arrayLength - 1];
                    arrayLength--;
                    j--;
                }
            }
        }
        int[] array1 = Arrays.copyOf(myArray, arrayLength);
        for (int i:array1) {
            System.out.print(i + " ");
        };
        writeToFile(array1);
    }

    public static void writeToFile(int[] integers)throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("integers.ser"));
        outputStream.writeObject(integers);
        outputStream.flush();
        outputStream.close();
        System.out.println("A list is write successfully");
    }
}
