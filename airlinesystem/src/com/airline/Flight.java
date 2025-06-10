package com.airline;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int capacity;
    private int availableSeats;
    private double price;
    public Flight(String flightNumber, String origin, String destination, int capacity, double price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.availableSeats = capacity;
        this.price = price;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < capacity) {
            availableSeats++;
        }
    }
    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("Flight %s: %s → %s | ₹%.2f | Seats left: %d",
                flightNumber, origin, destination, price, availableSeats);
    }
}
