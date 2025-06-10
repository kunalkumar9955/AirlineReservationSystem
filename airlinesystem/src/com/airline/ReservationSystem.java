package com.airline;
import java.util.*;
public class ReservationSystem {
    private List<Flight> flights = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    public ReservationSystem() {
        flights.add(new Flight("AI101", "Delhi", "Mumbai", 100, 4500));
        flights.add(new Flight("AI102", "Delhi", "Bangalore", 80, 6000));
        flights.add(new Flight("AI103", "Mumbai", "Chennai", 50, 5500));
    }
    public void addFlight(Flight flight) {
        flights.add(flight);
    }
    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> result = new ArrayList<>();
        for (Flight f : flights) {
            if (f.getOrigin().equalsIgnoreCase(origin) &&
                    f.getDestination().equalsIgnoreCase(destination)) {
                result.add(f);
            }
        }
        return result;
    }
    public Booking bookFlight(String name, String flightNumber) throws Exception {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be empty.");

        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                if (f.bookSeat()) {
                    Booking b = new Booking(name, f, "BKG" + bookingCounter++);
                    bookings.add(b);
                    return b;
                } else throw new Exception("No seats available!");
            }
        }
        throw new Exception("Flight not found.");
    }
    public boolean cancelBooking(String bookingId) {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getBookingId().equalsIgnoreCase(bookingId)) {
                b.getFlight().cancelSeat(); // Use getter method
                it.remove();
                return true;
            }
        }
        return false;
    }
    public void listBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking b : bookings) {
                System.out.println(b);
            }
        }
    }
//    public void addFlight(Flight flight) {
//        flights.add(flight);
//    }
}
