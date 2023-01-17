package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental each : rentals) {
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getAmount()).append("\n");
        }

        //add footer lines result
        result.append("Amount owed is ").append(totalAmount()).append("\n");
        result.append("You earned ").append(totalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + getName() + "</b></h1><br/>");
        for (Rental each : rentals) {
            //show figures for this rental
            result.append(each.getMovie().getTitle()).append(" ").append(each.getAmount()).append("<br/>");
        }

        //add footer lines result
        result.append("Amount owed is <b>").append(totalAmount()).append("</b><br/>");
        result.append("You earned <b>").append(totalFrequentRenterPoints()).append("</b> frequent renter points");
        return result.toString();
    }

    private int totalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
        for (Rental each : rentals) {
            totalFrequentRenterPoints += each.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }

    private double totalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.getAmount();
        }
        return totalAmount;
    }

}

