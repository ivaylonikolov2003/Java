import java.io.*;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;
    private LocalDate birth;
    private transient int age;

    public Person(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
        this.age = calculateAge();
    }

    private int calculateAge() {
        return LocalDate.now().getYear() - birth.getYear();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.age = calculateAge();
    }

    @Override
    public String toString() {
        return name + " " + birth + " " + age;
    }

    public static void main(String[] args) {

        Person[] people = {
                new Person("Luchezar Dimitrov", LocalDate.of(2003, 10, 25)),
                new Person("Nasko Kolev", LocalDate.of(2003, 6, 15)),
                new Person("Alex Petkov", LocalDate.of(2003, 2, 14))

        };

        final String filePath = "people.bin";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(people);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Person[] peopleFromFile = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            peopleFromFile = (Person[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (peopleFromFile != null) {
            System.out.println("Deserialized People:");
            for (Person person : peopleFromFile) {
                System.out.println(person);
            }
        }
    }
}
