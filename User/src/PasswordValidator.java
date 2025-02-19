public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        if (password.length() < 11 || !password.matches("^[a-zA-Z]*$")) {
            return false;
        }
        return true;
    }
}