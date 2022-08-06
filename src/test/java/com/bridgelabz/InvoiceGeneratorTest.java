package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    @Test
    void given_DistanceAndTime_ShouldReturn_TotalFare() {
        double distance = 5.0; //distance in kilometers
        int time = 10; //time in minutes
        double fare = invoiceGenerator.calculateFare(distance, time); //Total fare calculations
        Assertions.assertEquals(60 , fare);           //5*10 + 1*10
    }

    @Test
    void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1; //distance in kilometers
        int time = 1; //time in minutes
        double fare = invoiceGenerator.calculateFare(distance, time); //Total fare calculations
        Assertions.assertEquals(5 , fare);         //0.1*10 + 1*1
    }

    @Test
    void givenMultipleRides_shouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0 , 5),
        new Ride(5.0 , 10)};
        double fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(85, fare);
    }
}
