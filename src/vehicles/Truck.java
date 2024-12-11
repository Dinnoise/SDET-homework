package vehicles;

public class Truck extends Vehicle implements Engine, FuelConsumption {
    private double loadCapacity;

    public Truck(String brand, int year, double loadCapacity) {
        super(brand, year); // Вызов параметризованного конструктора родителя
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Бренд авто: " + brand);
        System.out.println("Год выпуска: " + year);
        System.out.println("Грузоподъемность: " + loadCapacity + " тонн/а");
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
        // Более сложная логика для грузовика
        double efficiency = distance / fuel;
        if (loadCapacity > 5) {
            efficiency *= 0.85; // Снижение эффективности при большой загрузке
        }
        return efficiency;
    }

    // Метод для загрузки груза с использованием условия
    public void loadCargo(double cargo) {
        if (cargo > loadCapacity) {
            System.out.println("Невозможно загрузить груз, превышает вместимость.");
        } else {
            System.out.println("Груз загружен: " + cargo + " тонн/а");
        }
    }
}