package vehicle;

import java.util.*;

abstract class Car{
    private String make;
    private String model;
    private double mileage;
    /** Creates a car with a starting mileage on the odometer.
    @throws IllegalArgumentException if startingMileage is negative*/
    public Car(String make, String model, double startingMileage) {
        this.make = make;
        this.model = model;
        if (startingMileage < 0) {
            throw new IllegalArgumentException();
        }
        this.mileage = startingMileage;
    }

    /** Starting mileage is 0. */
    public Car(String make, String model) {
        this(make, model, 0);
    }
    
    /** If able to drive the full given number of miles, returns true. If
    not, returns false.
    @throws IllegalArgumentException if miles is negative.*/
    public boolean canDrive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        return miles <= getRemainingRange();
    }

    /** Drives the full given number of miles.
    @throws IllegalArgumentException if miles is negative or if miles is
    too high given the current fuel. */
    public abstract void drive(double miles);
    
    /** Gives String representation of Car as
    "<make and model> (<mileage> mi)"
    Mileage should be rounded to 1 decimal place. If mileage is a whole
    number, ".0" should still display.
    */
    public String toString() {
        //return make + " " + model + " (" + getMileage() + " mi)"; //make it round to 1 decimal place
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), getMileage());
    }

    /** Returns how many miles have been driven so far (odometer). */
    public double getMileage() {
        return mileage;
    }

    /** Returns the make of the car. */
    public String getMake() {
        return make;
    }

    /** Returns the model of the car. */
    public String getModel() {
        return model;
    }

    /** Returns how many more miles the car can currently go given the
    remaining fuel/energy reserves. */
    public abstract double getRemainingRange();

    /** Adds mileage to the odometer.
    @throws IllegalArgumentException if miles is negative. */
    protected void addMileage(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException();
        }
        mileage += miles;
    }

    /** The car attempts to drive, in order, each of the daily number of
    miles in the list milesEachDay. Once the car cannot drive one of the
    day???s distance, no more days are attempted. Returns the number of
    days successfully driven.
    @throws IllegalArgumentException if miles is negative for any of the
    attempted days.*/
    public int roadTrip(List<Double> milesEachDay) {
        for (int i = 0; i < milesEachDay.size(); i++) {
            if (milesEachDay.get(i) < 0) {
                throw new IllegalArgumentException();
            }
        }
        int days = 0;
        Double miles;
        for (int i = 0; i < milesEachDay.size(); i++) {
            miles = milesEachDay.get(i);
            if (!canDrive(miles)) {
                return days;
            }
            drive(miles);
            days++;
        }
        return days;
    }
}