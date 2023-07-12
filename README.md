# Console Vehicle Manager

This is a simple console-based vehicle management system implemented in Java. It allows you to add vehicles to a queue and serve them for review. The program saves the vehicle queue to a file and loads it back when the program starts.

## Getting Started

To run the program, follow these steps:

1. Clone the repository or download the source code.
2. Make sure you have Java JDK installed on your system.
3. Open a command prompt or terminal and navigate to the project directory.
4. Compile the Java files by running the following command:
```javac Main.java```
5. Run the program with the following command:
```java Main```

## Usage

When you run the program, you will see a console menu with the following options:

* Quit (0): Exit the program and save the vehicle queue to a file.
* Add vehicle to queue (1): Add a new vehicle to the queue. You will be prompted to enter the vehicle's details such as type, brand, model, year, mileage, and VIN number.
* Serve next vehicle (2): Display the details of the next vehicle in the queue and remove it from the queue. If the queue is empty, a message will be shown.

## File IO
The program uses the **'FileIO'** class to load and save the vehicle queue to a file. The **'loadQueueFromFile'** method reads the data from the file and populates a **'Queue'** of **'Vehicle'** objects. The **'saveQueueToFile'** method writes the vehicle data from the queue to the file.

## Vehicle Class
The **'Vehicle'** class represents a vehicle object with properties such as type, brand, model, year, mileage, and VIN number. It provides getter and setter methods for accessing and modifying these properties. The **'toString'** method is overridden to provide a formatted string representation of the vehicle.

## Enum: Action
The **'Action'** enum defines the different actions that can be performed in the console menu. Each action has a corresponding value that is displayed in the menu. The **'getValue'** method returns the value associated with an action.

## ConsoleManager Class
The **'ConsoleManager'** class is responsible for managing the console menu and handling user input. It uses an instance of **'FileIO'** to load and save the vehicle queue. The **'runConsole'** method displays the console menu and calls the **'handleConsoleMenu'** method to handle user input.

## Contributing
Contributions to this project are welcome. You can fork the repository, make improvements, and submit a pull request.
