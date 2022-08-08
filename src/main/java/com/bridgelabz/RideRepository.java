package com.bridgelabz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides;

    public RideRepository() {
        userRides = new HashMap<>();
    }

    public void addRide(String userId, Ride[] ride) {
        this.userRides.computeIfAbsent(userId, k -> new ArrayList<>(Arrays.asList(ride)));
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}