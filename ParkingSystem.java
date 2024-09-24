import java.util.HashMap;
import java.util.Scanner;

class Car {
    String licensePlate;
    long entryTime;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = System.currentTimeMillis(); // Entry time in milliseconds
    }
}

public class ParkingSystem {
    private final int maxSpots;
    private HashMap<String, Car> parkingSpots;

    public ParkingSystem(int maxSpots) {
        this.maxSpots = maxSpots;
        this.parkingSpots = new HashMap<>();
    }

    public void parkCar(String licensePlate) {
        if (parkingSpots.size() < maxSpots) {
            Car car = new Car(licensePlate);
            parkingSpots.put(licensePlate, car);
            System.out.println("Car " + licensePlate + " parked successfully.");
        } else {
            System.out.println("No parking spots available.");
        }
    }

    public void checkoutCar(String licensePlate) {
        Car car = parkingSpots.get(licensePlate);
        if (car != null) {
            long currentTime = System.currentTimeMillis();
            long parkedDuration = (currentTime - car.entryTime) / (1000 * 60); // Duration in minutes
            double fee = calculateFee(parkedDuration);
            parkingSpots.remove(licensePlate);
            System.out.println("Car " + licensePlate + " checked out. Parking time: " + parkedDuration + " minutes. Fee: $" + fee);
        } else {
            System.out.println("Car not found.");
        }
    }

    private double calculateFee(long minutes) {
        return minutes * 0.05; // $0.05 per minute
    }

    public void displayAvailableSpots() {
        System.out.println("Available spots: " + (maxSpots - parkingSpots.size()));
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(3); // Create a parking system with 3 spots
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Enter a command (park, checkout, available, quit): ");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "park":
                    System.out.println("Enter license plate:");
                    String plate = scanner.nextLine();
                    parkingSystem.parkCar(plate);
                    break;

                case "checkout":
                    System.out.println("Enter license plate:");
                    String checkoutPlate = scanner.nextLine();
                    parkingSystem.checkoutCar(checkoutPlate);
                    break;

                case "available":
                    parkingSystem.displayAvailableSpots();
                    break;

                case "quit":
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        } while (!command.equalsIgnoreCase("quit"));

        scanner.close();
    }
}
