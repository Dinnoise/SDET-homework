public class AuthValidator {
    public static boolean validateCredentials(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и символы подчеркивания и содержать не более 20 символов.");
            }

            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Пароль должен состоять только из латинских букв, цифр и символов подчеркивания и содержать не более 20 символов.");
            }

            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
