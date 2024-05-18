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

        System.out.print("Введите количество этажей в здании: ");
        int numFloors = scanner.nextInt();
        
        System.out.print("введите количество вызовов: ");
        int numRequests = scanner.nextInt();

        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(1);

        for (int i = 0; i < numRequests; i++) {
            System.out.print("Введите через пробел текущий этаж и этаж назначения для запроса " + (i + 1) + ": ");
            int currentFloor = scanner.nextInt();
            int destinationFloor = scanner.nextInt();

            handleRequest(elevator1, elevator2, currentFloor, destinationFloor);
            System.out.println("Лифт 1: " + elevator1.currentFloor + " - Запросы: " + elevator1.requests);
            System.out.println("Лифт 2: " + elevator2.currentFloor + " - Запросы: " + elevator2.requests);
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
