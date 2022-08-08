package com.bridgelabz;
public class InvoiceGenerator {
    private final RideRepository rideRepository;

    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(Ride ride)
    {
        return Math.max(ride.rideTypes.MIN_FARE,
                ride.getDistance() * ride.rideTypes.RS_PER_KILOMETER + ride.getTime() * ride.rideTypes.RS_PER_MINUTE);
    }
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride);
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
