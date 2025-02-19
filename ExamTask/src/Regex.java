import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Regex implements Serializable {
    private int id;
    private String pattern;
    private String description;
    private int rating;
    private static int nextId = 0;

    public Regex(String pattern, String description) {
        this.id = ++nextId;
        this.pattern = pattern;
        this.description = description;
        this.rating = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    static List<Regex> readFromFile() {
        List<Regex> regexes = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("regexList.ser"))){

            while (true){
                regexes.add((Regex) inputStream.readObject());
            }
        }catch (EOFException e){
            return regexes;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    static void writeToFile(List<Regex> regexList){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("regexList.ser")))
        {
            for (int i = 0; i < regexList.size(); i++) {
                outputStream.writeObject(regexList.get(i));
            }
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "pattern='" + pattern + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating;
    }
}
