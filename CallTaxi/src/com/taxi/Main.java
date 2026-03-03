package com.taxi;

import com.taxi.service.TaxiService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaxiService service = new TaxiService(4);

        while (true) {

            System.out.println("\n===== CALL TAXI BOOKING SYSTEM =====");
            System.out.println("1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number only.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Customer ID: ");
                    int customerId = sc.nextInt();

                    System.out.print("Enter Pickup Point (A-E): ");
                    char from = sc.next().toUpperCase().charAt(0);

                    System.out.print("Enter Drop Point (A-E): ");
                    char to = sc.next().toUpperCase().charAt(0);

                    if (!isValidPoint(from) || !isValidPoint(to)) {
                        System.out.println("Invalid location! Use A to E only.");
                        break;
                    }

                    if (from == to) {
                        System.out.println("Pickup and Drop cannot be same!");
                        break;
                    }

                    System.out.print("Enter Pickup Time (in hours): ");
                    int pickupTime = sc.nextInt();

                    service.bookTaxi(customerId, from, to, pickupTime);
                    break;

                case 2:
                    service.displayTaxis();
                    break;

                case 3:
                    System.out.println("Thank you for using Call Taxi App 🚖");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static boolean isValidPoint(char point) {
        return point >= 'A' && point <= 'E';
    }
}