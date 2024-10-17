import vehicles.Car;
import vehicles.Truck;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2018, 4);
        Truck truck = new Truck("Volvo", 2020, 7.5);

        // Вызов методов автомобиля
        car.displayInfo();
        car.startEngine();
        car.drive(50);
        System.out.println("Расход топлива: " + car.calculateFuelEfficiency(5, 100) + " км/ч");
        car.stopEngine();

        System.out.println();

        // Вызов методов грузовика
        truck.displayInfo();
        truck.startEngine();
        truck.loadCargo(6);
        System.out.println("Расход топлива: " + truck.calculateFuelEfficiency(8, 200) + " км/ч");
        truck.stopEngine();

        // Статический метод
        System.out.println("Всего создано транспортных средств: " + Truck.getVehicleCount());
    }
}