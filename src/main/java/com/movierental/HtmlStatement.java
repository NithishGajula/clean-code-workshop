package com.movierental;

public class HtmlStatement {
    public String display(String name, Rentals rentals) {
        StringBuilder result = new StringBuilder("<h1>Rental Record for <b>" + name + "</b></h1><br/>");
        for (Rental each : rentals) {
            //show figures for this rental
            result.append(each.getMovie().getTitle()).append(" ").append(each.getAmount()).append("<br/>");
        }

        //add footer lines result
        result.append("Amount owed is <b>").append(rentals.totalAmount()).append("</b><br/>");
        result.append("You earned <b>").append(rentals.totalFrequentRenterPoints()).append("</b> frequent renter points");
        return result.toString();
    }
}
