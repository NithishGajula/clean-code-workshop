package com.movierental;

public class TextStatement {
    public String display(String name, Rentals rentals) {
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");
        for (Rental each : rentals) {
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getAmount()).append("\n");
        }

        //add footer lines result
        result.append("Amount owed is ").append(rentals.totalAmount()).append("\n");
        result.append("You earned ").append(rentals.totalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }
}
