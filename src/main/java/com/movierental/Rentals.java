package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {
    int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental each : this) {
            totalFrequentRenterPoints += each.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    double totalAmount() {
        double totalAmount = 0;
        for (Rental each : this) {
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }
}
