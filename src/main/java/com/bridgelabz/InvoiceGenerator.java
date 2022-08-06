package com.bridgelabz;

public class InvoiceGenerator {
    private static final int RS_PER_MINUTE = 1; //min cost per minute
    private static final double RS_PER_KILOMETER = 10; //min cost per kilometer
    private static final double MIN_FARE = 5;
    static double Total_Fare;

    public double calculateFare(double distance , int time) {
        //calculation of total fare
        Total_Fare = distance * RS_PER_KILOMETER + time * RS_PER_MINUTE;
        return Math.max(Total_Fare, MIN_FARE);

    }

    public static void main(String[] args) {
        InvoiceGenerator ii = new InvoiceGenerator();
        ii.calculateFare(5,10);
        System.out.println(Total_Fare);
    }
}
