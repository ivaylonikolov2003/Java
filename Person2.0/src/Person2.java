import java.io.*;
import java.time.LocalDate;

public class Person2 implements Externalizable {

    private String name;
    private LocalDate birth;
    private int age;
    private transient String address;

    public Person2() {
    }

    public Person2(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
        this.age = age();
        this.address = address;
    }

    private int age() {
        return LocalDate.now().getYear() - birth.getYear();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(birth);
        out.writeInt(age);
        out.writeObject(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        birth = (LocalDate) in.readObject();
        age = in.readInt();
        address = (String) in.readObject();
        age = age();
    }

    @Override
    public String toString() {
        return name + " " + birth + " " + age + " " + address;
    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("persons.dat"));
            Person2[] persons = {new Person2("Luchezar Dimitrov", LocalDate.of(2003, 10, 25)),
                    new Person2("Nasko Kolev", LocalDate.of(2003, 6, 15)),
                    new Person2("Alex Petkov", LocalDate.of(2003, 2, 14))};
            oos.writeObject(persons);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("persons.dat"));
            Person2[] readPersons = (Person2[]) ois.readObject();
            ois.close();

            for (Person2 person : readPersons) {
                System.out.println(person);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
