package com.bridgelabz;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceServiceTest {
    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25,fare,0.0);
    }
    @Test
    void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5,fare,0.0);

    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                 new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary,summary);

    }
    @Test
    public void givenUserIdShouldReturnTheInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

        String userId = "anant12";
        Ride[] rides = {
                 new Ride(2.0, 5),
                new Ride(0.1, 1),
                new Ride(0.1, 1)

        };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(3,35.0);
        assertEquals(summary,checkSummary);
    }

}
