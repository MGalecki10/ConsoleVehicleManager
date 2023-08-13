package pl.MGalecki10.io;

import pl.MGalecki10.model.Vehicle;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class FileIO {

    public Queue<Vehicle> loadQueueFromFile(String fileName) {
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found. Creating a new file: " + fileName);
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating a new file: " + fileName);
            } catch (NullPointerException e) {
                System.out.println("lalala");
            }
            return vehicleQueue;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split(";");
                String type = vehicleData[0];
                String brand = vehicleData[1];
                String model = vehicleData[2];
                int year = Integer.parseInt(vehicleData[3].trim());
                double mileage = Double.parseDouble(vehicleData[4].trim());
                String numberVin = vehicleData[5].trim();
                vehicleQueue.add(new Vehicle(type, brand, model, year, mileage, numberVin));
            }
            return vehicleQueue;
        } catch (IOException e) {
            System.out.println("Error loading data from file.");
        }
        return vehicleQueue;
    }

    public void saveQueueToFile(Queue<Vehicle> vehicleQueue, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vehicle vehicle : vehicleQueue) {
                writer.write(vehicle.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file");
        }
    }
}
