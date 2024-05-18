import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Elevator {
    int currentFloor;
    int FromElevator;
    List<Integer> requests;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;
        this.requests = new ArrayList<>();
        this.FromElevator = FromElevator;
    }
}

public class ElevatorSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество этажей в здании (должно быть больше 0): ");
        int numFloors = scanner.nextInt();

        while (numFloors <= 0) {
            System.out.println("Количество этажей должно быть больше 0. Пожалуйста, попробуйте снова.");
            System.out.print("Введите количество этажей в здании (должно быть больше 0): ");
            numFloors = scanner.nextInt();
        }

        System.out.print("Введите количество запросов (должно быть больше 0): ");
        int numRequests = scanner.nextInt();

        while (numRequests <= 0) {
            System.out.println("Количество запросов должно быть больше 0. Пожалуйста, попробуйте снова.");
            System.out.print("Введите количество запросов (должно быть больше 0): ");
            numRequests = scanner.nextInt();
        }

        Elevator elevator1 = new Elevator(1);
        Elevator elevator2 = new Elevator(1);
        elevator1.FromElevator = 1;
        elevator2.FromElevator = 1;
        elevator1.currentFloor = 1;
        elevator1.currentFloor = 1;

        for (int i = 0; i < numRequests; i++) {
            System.out.print("Введите текущий этаж и этаж назначения для запроса " + (i + 1) + ": ");
            int currentFloor = scanner.nextInt();
            int destinationFloor = scanner.nextInt();

            if (currentFloor <= 0 || currentFloor > numFloors || destinationFloor <= 0 || destinationFloor > numFloors) {
                System.out.println("Неверный ввод этажа. Пожалуйста, введите существующие номера этажей.");
                continue;
            }

            handleRequest(elevator1, elevator2, currentFloor, destinationFloor);
            System.out.println("Лифт 1: " + elevator1.FromElevator + " - Запросы: " + elevator1.requests);
            System.out.println("Лифт 2: " + elevator2.FromElevator + " - Запросы: " + elevator2.requests);
        }
    }

    public static void handleRequest(Elevator elevator1, Elevator elevator2, int currentFloor, int destinationFloor) {
        int distance1 = Math.abs(elevator1.currentFloor - currentFloor);
        int distance2 = Math.abs(elevator2.currentFloor - currentFloor);

        if (distance1 <= distance2) {
            elevator1.FromElevator = elevator1.currentFloor;
            if (currentFloor != elevator1.FromElevator) {
            elevator1.requests.add(currentFloor);
            }
            elevator1.requests.add(destinationFloor);
            elevator1.currentFloor = destinationFloor;
        } else {
            elevator2.FromElevator = elevator2.currentFloor;
            if (currentFloor != elevator2.FromElevator) {
            elevator2.requests.add(currentFloor);
            }
            elevator2.requests.add(destinationFloor);
            elevator2.currentFloor = destinationFloor;
        }
    }
}
