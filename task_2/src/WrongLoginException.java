public class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Неверный формат или длина входа.");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
