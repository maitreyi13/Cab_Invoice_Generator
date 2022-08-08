package com.bridgelabz;

public class Ride {
    public int time;
    public double distance;
    public RideTypes rideTypes;
    public Ride(RideTypes rideTypes,  double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideTypes = rideTypes;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }
}
