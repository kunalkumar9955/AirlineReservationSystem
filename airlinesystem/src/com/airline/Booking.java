package com.airline;

public class Booking {
    private String bookingId;
    private String passengerName;
    private Flight flight;

    public Booking(String passengerName, Flight flight, String bookingId) {
        this.passengerName = passengerName;
        this.flight = flight;
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public String getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return String.format("BookingID: %s | Name: %s | Flight: %s", bookingId, passengerName, flight.getFlightNumber());
    }
}
