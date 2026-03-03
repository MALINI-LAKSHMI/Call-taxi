package com.taxi.Bean;

public class Booking {

    private static int idCounter = 1;

    private int bookingId;
    private int customerId;
    private char from;
    private char to;
    private int pickupTime;
    private int dropTime;
    private int amount;

    public Booking(int customerId, char from, char to, int pickupTime,
                   int dropTime, int amount) {
        this.bookingId = idCounter++;
        this.customerId = customerId;
        this.from = from;
        this.to = to;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

    public int getAmount() { return amount; }

    public void display() {
        System.out.println(bookingId + "    " + customerId + "    " +
                from + "    " + to + "    " +
                pickupTime + "    " + dropTime + "    " + amount);
    }
}