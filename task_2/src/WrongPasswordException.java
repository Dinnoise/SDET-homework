public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Неверный формат и длина пароля или пароли не совпадают.");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}