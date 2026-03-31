package regex;

public class UsernameValidation {

    public static boolean isValidUsername(String username) {

        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }

    public static void main(String[] args) {

        String username1 = "user_123";
        String username2 = "123user";
        String username3 = "user";
        System.out.println(isValidUsername(username1));
        System.out.println(isValidUsername(username2));
        System.out.println(isValidUsername(username3));
    }
}
