package vehicles;

public class Car extends Vehicle implements Engine, FuelConsumption {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year); // Вызов параметризованного конструктора родителя
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Бренд авто: " + brand);
        System.out.println("Год выпуска: " + year);
        System.out.println("Количество дверей: " + numberOfDoors);
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатель автомобиля запустился.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Двигатель автомобиля остановился.");
    }

    @Override
    public double calculateFuelEfficiency(double fuel, double distance) {
        if (fuel <= 0 || distance <= 0) {
            throw new IllegalArgumentException("Топливо и расстояние должны быть положительными.");
        }
        return distance / fuel; // Простой расчёт расхода топлива
    }

    // Метод, использующий цикл и условие
    public void drive(int distance) {
        System.out.println("Проехав " + distance + " километров...");
        for (int i = 0; i < distance; i += 10) {
            System.out.println("Путь: " + i + " км");
        }
        System.out.println("Прибыл в пункт назначения.");
    }
}