package com.bridgelabz;
public class InvoiceGenerator {
    private static final int RS_PER_MINUTE = 1; //min cost per minute
    private static final double RS_PER_KILOMETER = 10; //min cost per kilometer
    private static final double MIN_FARE = 5;
    private final RideRepository rideRepository;

    static double Total_Fare;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(double distance , int time) {
        //calculation of total fare
        Total_Fare = distance * RS_PER_KILOMETER + time * RS_PER_MINUTE;
        return Math.max(Total_Fare, MIN_FARE);
    }
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }

    public void addRides(String userId, Ride[] ride) {
        rideRepository.addRide(userId, ride);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
