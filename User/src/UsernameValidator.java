public class UsernameValidator {
    public static boolean isValidUsername(String username) {
        if (username.length() < 3 || username.length() > 15 || !username.matches("^[a-z0-9_-]*$")) {
            return false;
        }
        return true;
    }
}