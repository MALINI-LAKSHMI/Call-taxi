package com.taxi.Bean;

import java.util.ArrayList;
import java.util.List;

public class Taxi {

    private int taxiId;
    private char currentLocation;
    private int freeTime;
    private int totalEarnings;
    private List<Booking> bookings;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentLocation = 'A';
        this.freeTime = 0;
        this.totalEarnings = 0;
        this.bookings = new ArrayList<>();
    }

    public int getTaxiId() { return taxiId; }
    public char getCurrentLocation() { return currentLocation; }
    public int getFreeTime() { return freeTime; }
    public int getTotalEarnings() { return totalEarnings; }

    public void addBooking(Booking booking, char dropPoint, int dropTime) {
        bookings.add(booking);
        currentLocation = dropPoint;
        freeTime = dropTime;
        totalEarnings += booking.getAmount();
    }

    public void displayDetails() {
        System.out.println("Taxi-" + taxiId +
                " Total Earnings: Rs. " + totalEarnings);

        System.out.println("BookingID CustomerID From To Pickup Drop Amount");

        for (Booking b : bookings) {
            b.display();
        }
        System.out.println();
    }
}