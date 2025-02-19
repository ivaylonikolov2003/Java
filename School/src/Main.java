public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Vasil Levski 4");
        Student student = new Student("Ivailo", "Vasil Levski 5", "KSI", 2, 550.0);
        Staff staff = new Staff("Lelka", "Petar Danov 16", "TU SOFIA", 2543.23);

        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);
    }
}
