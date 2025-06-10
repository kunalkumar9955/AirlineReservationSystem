package com.airline;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n✈ Airline Reservation System");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("From: ");
                        String from = sc.nextLine();
                        System.out.print("To: ");
                        String to = sc.nextLine();
                        List<Flight> results = system.searchFlights(from, to);
                        if (results.isEmpty()) System.out.println("No flights found.");
                        else results.forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Passenger Name: ");
                        String name = sc.nextLine();
                        System.out.print("Flight Number: ");
                        String flightNum = sc.nextLine();
                        Booking b = system.bookFlight(name, flightNum);
                        System.out.println("Booking Confirmed: " + b);
                    }
                    case 3 -> {
                        System.out.print("Booking ID: ");
                        String id = sc.nextLine();
                        boolean success = system.cancelBooking(id);
                        System.out.println(success ? "Booking Cancelled." : "Invalid Booking ID.");
                    }
                    case 4 -> system.listBookings();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
    }
}
