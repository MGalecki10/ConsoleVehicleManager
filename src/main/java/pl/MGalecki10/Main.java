package pl.MGalecki10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "vehicle_queue.txt";

    public static void main(String[] args) {
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        ConsoleManager consoleManager = new ConsoleManager();
        FileIO fileIO = new FileIO();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            option = consoleManager.runConsole(scanner, vehicleQueue, fileIO, FILE_NAME);
        }
        while(option != 0);
    }
}