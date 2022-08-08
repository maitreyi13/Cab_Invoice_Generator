package com.bridgelabz;

public enum RideTypes {
    NORMAL_RIDE(10.0, 1, 5.0),
    PREMIUM_RIDE(15.0, 2, 20.0);

    public final int RS_PER_MINUTE; //min cost per minute
    public final double RS_PER_KILOMETER; //min cost per kilometer
    public final double MIN_FARE;

    private RideTypes(double RS_PER_KILOMETER, int RS_PER_MINUTE, double MIN_FARE)
    {
        this.RS_PER_MINUTE = RS_PER_MINUTE;
        this.RS_PER_KILOMETER = RS_PER_KILOMETER;
        this.MIN_FARE = MIN_FARE;
    }
    public double calculateFare(Ride ride)
    {
        return Math.max((ride.getDistance() * RS_PER_KILOMETER) + (ride.getTime() * RS_PER_MINUTE), MIN_FARE);
    }
}