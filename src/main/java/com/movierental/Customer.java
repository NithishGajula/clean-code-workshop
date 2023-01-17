package com.movierental;

public class Customer {
    private final String name;
    private Rentals rentals = new Rentals();

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
        Rentals rentals = this.rentals;
        return new TextStatement().display(this.getName(), rentals);
    }

    public String htmlStatement() {
        Rentals rentals = this.rentals;
        return new HtmlStatement().display(this.getName(), rentals);
    }

    private class TextStatement {
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

    private class HtmlStatement {
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
}

