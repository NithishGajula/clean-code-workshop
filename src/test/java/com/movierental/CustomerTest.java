package com.movierental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("Nithish");
        customer.addRental(new Rental(new Movie("RRR", 1), 5));
        customer.addRental(new Rental(new Movie("Pushpa", 2), 3));
        customer.addRental(new Rental(new Movie("KGF", 0), 2));
        customer.addRental(new Rental(new Movie("Kantara", 1), 1));
    }

    @Test
    public void testStatement() {
        assertEquals("Rental Record for Nithish\n" +
                "\tRRR\t15.0\n" +
                "\tPushpa\t1.5\n" +
                "\tKGF\t2.0\n" +
                "\tKantara\t3.0\n" +
                "Amount owed is 21.5\n" +
                "You earned 5 frequent renter points", customer.statement());
    }

    @Test
    public void testHTMLStatement() {
        assertEquals("<h1>Rental Record for <b>Nithish</b></h1><br/>RRR 15.0<br/>Pushpa 1.5<br/>KGF 2.0<br/>Kantara 3.0<br/>Amount owed is <b>21.5</b><br/>You earned <b>5</b> frequent renter points", customer.htmlStatement());
    }

}