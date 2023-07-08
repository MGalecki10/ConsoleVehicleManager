package pl.MGalecki10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "vehicle_queue.txt";

    public static void main(String[] args) {
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.runConsole(FILE_NAME);

    }
}