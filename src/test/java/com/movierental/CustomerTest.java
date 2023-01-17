package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void test(){
        Customer customer = new Customer("Nithish");
        customer.addRental(new Rental(new Movie("RRR", 1), 5));
        customer.addRental(new Rental(new Movie("Pushpa", 2), 3));
        customer.addRental(new Rental(new Movie("KGF", 0), 2));
        customer.addRental(new Rental(new Movie("Kantara", 1), 1));

        assertEquals("Rental Record for Nithish\n" +
                "\tRRR\t15.0\n" +
                "\tPushpa\t1.5\n" +
                "\tKGF\t2.0\n" +
                "\tKantara\t3.0\n" +
                "Amount owed is 21.5\n" +
                "You earned 5 frequent renter points", customer.statement());
    }

}