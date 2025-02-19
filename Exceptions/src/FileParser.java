import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    static List<Integer> readIntsFromTextFile(String fileName) throws IOException, FileParseException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Integer> ints = new ArrayList<Integer>();
        int lineNum = 1;
        String line = "";
        try {
            while ((line = reader.readLine()) != null){
                if(line.length() > 0)
                    ints.add(Integer.parseInt(line));
                lineNum++;
            }
        }catch (Exception ex){
            throw new FileParseException("Error parsing file" + fileName, lineNum, line);
        }
        finally {
            reader.close();
        }
        return ints;

    }
}
