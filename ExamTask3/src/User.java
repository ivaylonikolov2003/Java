import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password) throws UserException {
        boolean bname = Pattern.matches("[A-Za-z0-9]{5}", username);
        boolean bpassword = Pattern.matches("[A-Za-z0-9]{5}", password);

        if (!bname || bpassword){
            throw new UserException("Wrong data is entered");
        }
    }

    @Override
    public int hashCode(){
        return username.hashCode();
    }

    public void addFilePath(List<String> filePaths, String filePath){
        filePaths.add(filePath);
    }

    public List<String> getFilePaths(List<String> filePaths){
        return filePaths;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
