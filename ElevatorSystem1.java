import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Elevator {
    int currentFloor;
    List<Integer> requests;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.requests = new ArrayList<>();
    }
}

public class ElevatorSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of floors in the building (must be greater than 0): ");
        int numFloors = scanner.nextInt();

        while (numFloors <= 0) {
            System.out.println("Number of floors must be greater than 0. Please try again.");
            System.out.print("Enter the number of floors in the building (must be greater than 0): ");
            numFloors = scanner.nextInt();
        }

        System.out.print("Enter the number of requests (must be greater than 0): ");
        int numRequests = scanner.nextInt();

        while (numRequests <= 0) {
            System.out.println("Number of requests must be greater than 0. Please try again.");
            System.out.print("Enter the number of requests (must be greater than 0): ");
            numRequests = scanner.nextInt();
        }

        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(1);

        for (int i = 0; i < numRequests; i++) {
            System.out.print("Enter the current floor and destination floor for request " + (i + 1) + ": ");
            int currentFloor = scanner.nextInt();
            int destinationFloor = scanner.nextInt();

            if (currentFloor <= 0 || currentFloor > numFloors || destinationFloor <= 0 || destinationFloor > numFloors) {
                System.out.println("Invalid floor input. Please enter existing floor numbers.");
                continue;
            }

            handleRequest(elevator1, elevator2, currentFloor, destinationFloor);
            System.out.println("Elevator 1: 1" + " - Requests: " + elevator1.requests);
            System.out.println("Elevator 2: 1" + " - Requests: " + elevator2.requests);
        }
    }

    public static void handleRequest(Elevator elevator1, Elevator elevator2, int currentFloor, int destinationFloor) {
        int distance1 = Math.abs(elevator1.currentFloor - currentFloor);
        int distance2 = Math.abs(elevator2.currentFloor - currentFloor);

        if (distance1 <= distance2) {
            elevator1.requests.add(destinationFloor);
            elevator1.currentFloor = currentFloor;
        } else {
            elevator2.requests.add(destinationFloor);
            elevator2.currentFloor = currentFloor;
        }
    }
}
