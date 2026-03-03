package com.taxi.service;

import com.taxi.Bean.Booking;
import com.taxi.Bean.Taxi;

import java.util.ArrayList;
import java.util.List;

public class TaxiService {

    private List<Taxi> taxis = new ArrayList<>();

    public TaxiService(int taxiCount) {
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char from, char to, int pickupTime) {

        System.out.println("\nCustomer ID: " + customerId +
                " Pickup: " + from +
                " | Drop: " + to +
                " Pickup Time: " + pickupTime);

        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            if (taxi.getFreeTime() <= pickupTime) {

                int distance = Math.abs(taxi.getCurrentLocation() - from);

                if (distance < minDistance) {
                    minDistance = distance;
                    selectedTaxi = taxi;
                }
                else if (distance == minDistance) {
                    if (selectedTaxi == null ||
                            taxi.getTotalEarnings() <
                            selectedTaxi.getTotalEarnings()) {
                        selectedTaxi = taxi;
                    }
                }
            }
        }

        if (selectedTaxi == null) {
            System.out.println("Taxi cannot be allotted.");
            return;
        }

        int distancePoints = Math.abs(from - to);
        int kms = distancePoints * 15;

        int amount = 100;
        if (kms > 5) {
            amount += (kms - 5) * 10;
        }

        int dropTime = pickupTime + distancePoints;

        Booking booking = new Booking(customerId, from, to,
                pickupTime, dropTime, amount);

        selectedTaxi.addBooking(booking, to, dropTime);

        System.out.println("Taxi can be allotted. Taxi-" +
                selectedTaxi.getTaxiId() + " is allotted.");
    }
    public void displayTaxis() {
        for (Taxi taxi : taxis) {
            taxi.displayDetails();
        }
    }
}