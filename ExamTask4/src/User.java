import java.util.ArrayList;

public class User {
    public String email;
    public String pass;
    public ArrayList<Grade> grades;

    public User(String email, String pass, ArrayList<Grade> grades) {
        this.email = email;
        this.pass = pass;
        this.grades = new ArrayList<>();
    }
}
