public class Main {
    public static void main(String[] args) {
        String login = "User123";
        String password = "pass123_";
        String confirmPassword = "pass123_";

        boolean isValid = AuthValidator.validateCredentials(login, password, confirmPassword);
        System.out.println("Результат проверки: " + isValid);
    }

}