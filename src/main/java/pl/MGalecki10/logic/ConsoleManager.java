package pl.MGalecki10.logic;

import pl.MGalecki10.io.FileIO;
import pl.MGalecki10.model.Vehicle;
import pl.MGalecki10.model.Action;

import java.util.Queue;
import java.util.Scanner;

public class ConsoleManager {
    private static final String FILE_NAME = "vehicle_queue.txt";
    private Queue<Vehicle> vehicleQueue;
    private FileIO fileIO = new FileIO();
    private Scanner scanner = new Scanner(System.in);

    ConsoleManager() {
        vehicleQueue = fileIO.loadQueueFromFile(FILE_NAME);
    }

    void runConsole() {
        Action action;
        do {
            showConsoleOptions();
            action = handleConsoleMenu();
        } while (action != Action.QUIT);
    }

    void showConsoleOptions() {
        System.out.println("What action do you want to take:");
        System.out.println(Action.QUIT.getValue() + " - Quit");
        System.out.println(Action.ADD_TO_QUEUE.getValue() + " - Add vehicle to queue");
        System.out.println(Action.NEXT_REVIEW.getValue() + " - Serve next vehicle");
        System.out.println("Enter option");
    }

    Action handleConsoleMenu() {
        int option = scanner.nextInt();
        scanner.nextLine();
        Action action = Action.values()[option];
        switch (action) {
            case QUIT:
                fileIO.saveQueueToFile(vehicleQueue, FILE_NAME);
                break;
            case ADD_TO_QUEUE:
                Vehicle newVehicle = readVehicleDataFromUser(scanner);
                vehicleQueue.add(newVehicle);
                break;
            case NEXT_REVIEW:
                if (vehicleQueue.isEmpty()) {
                    System.out.println("Queue is empty. Exiting the application");
                    fileIO.saveQueueToFile(vehicleQueue, FILE_NAME);
                } else {
                    System.out.println("Vehicle to inspect:");
                    System.out.println(vehicleQueue.poll());
                }
        }
        return action;
    }

    Vehicle readVehicleDataFromUser(Scanner scanner) {
        System.out.println("Enter type");
        String type = scanner.nextLine();

        System.out.println("Enter brand");
        String brand = scanner.nextLine();

        System.out.println("Enter model");
        String model = scanner.nextLine();

        System.out.println("Enter year");
        int year = scanner.nextInt();

        System.out.println("Enter mileage");
        double mileage = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter vinNumber");
        String vinNumber = scanner.nextLine();

        return new Vehicle(type, brand, model, year, mileage, vinNumber);
    }
}
