package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    @Test
    void given_DistanceAndTime_ShouldReturn_TotalFare() {
        Ride ride = new Ride(RideTypes.NORMAL_RIDE, 5, 1);
        double fare = invoiceGenerator.calculateFare(ride);
        Assertions.assertEquals(51 , fare);           //5*10 + 1*1
    }

    @Test
    void givenLessDistanceOrTime_ShouldReturnMinFare() {
        Ride ride = new Ride(RideTypes.NORMAL_RIDE, 0.1, 1);
        double fare = invoiceGenerator.calculateFare(ride); //Total fare calculations
        Assertions.assertEquals(5 , fare);         //0.1*10 + 1*1
    }

    @Test
    void givenMultipleRides_shouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(RideTypes.NORMAL_RIDE, 2.0, 5), new Ride(RideTypes.NORMAL_RIDE, 0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedSummary, summary);
    }

        @Test
        public void givenUserId_ShouldReturnInvoiceSummary () {
            String userId = "neha@13";
            Ride[] ride1 = {new Ride(RideTypes.NORMAL_RIDE, 2.0, 5), new Ride(RideTypes.NORMAL_RIDE, 0.1, 1)};
            invoiceGenerator.addRides(userId, ride1);
            InvoiceSummary summary1 = invoiceGenerator.getInvoiceSummary(userId);
            InvoiceSummary checkSummary = new InvoiceSummary(2, 30.0);
            Assertions.assertEquals(summary1, checkSummary);
        }

    @Test
    void givenUserIdWithRideType_ShouldReturnTheInvoice() {
        String userId = "addy@123";
        Ride[] rides = { new Ride(RideTypes.NORMAL_RIDE, 2.0, 5), new Ride(RideTypes.NORMAL_RIDE, 0.1, 1),
                new Ride(RideTypes.PREMIUM_RIDE, 0.1, 1) };
        invoiceGenerator.addRides(userId, rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary checkSummary = new InvoiceSummary(3, 50.0);
        Assertions.assertEquals(summary, checkSummary);
    }
}
