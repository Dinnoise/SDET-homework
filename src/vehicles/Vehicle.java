package vehicles;

public abstract class Vehicle {
    protected String brand;
    protected int year;

    // Статическое поле, общий счётчик для всех автомобилей
    protected static int vehicleCount = 0;

    // Параметризованный конструктор
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        vehicleCount++;
    }

    // Статический метод для получения общего количества автомобилей
    public static int getVehicleCount() {
        return vehicleCount;
    }

    // Абстрактный метод для вывода информации о транспортном средстве
    public abstract void displayInfo();

    // Метод для расчёта возраста транспортного средства
    public int calculateAge() {
        int currentYear = 2024;
        return currentYear - year;
    }
}
