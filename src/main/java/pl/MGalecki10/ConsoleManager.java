package pl.MGalecki10;

import java.util.Queue;
import java.util.Scanner;

public class ConsoleManager {

    int runConsole(Scanner scanner, Queue vehicleQueue, FileIO fileIO, String fileName) {
        showConsoleOptions();
        int option = handleConsoleMenu(scanner, vehicleQueue, fileIO, fileName);
        return option;
    }

    void showConsoleOptions() {
        System.out.println("What action do you want to take:");
        System.out.println(Action.QUIT.getButton() + " - Quit");
        System.out.println(Action.ADD_TO_QUEUE.getButton() + " - Add vehicle to queue");
        System.out.println(Action.NEXT_REVIEW.getButton() + " - Serve next vehicle");
        System.out.println("Enter option");
    }

    int handleConsoleMenu(Scanner scanner, Queue vehicleQueue, FileIO fileIO, String fileName) {
        int option = scanner.nextInt();
        scanner.nextLine();
        switch (option) {
            case 0:
                fileIO.saveQueueToFile(vehicleQueue, fileName);
                break;
            case 1:
                Vehicle newVehicle = readVehicleDataFromUser(scanner);
                vehicleQueue.add(newVehicle);
                break;
            case 2:
                if (vehicleQueue.isEmpty()) {
                    System.out.println("Queue is empty. Existing the application");
                    fileIO.saveQueueToFile(vehicleQueue, fileName);
                    option = 0;
                } else {
                    System.out.println("Vehicle to inspect:");
                    System.out.println(vehicleQueue.peek());
                    vehicleQueue.poll();
                }
        }
        return option;
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
