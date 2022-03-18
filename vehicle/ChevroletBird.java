package vehicle;

import java.util.*;


class ChevroletBird extends ElectricCar implements Flying{
    /** Chevrolet Birds have a 250 mile range on a full charge. They
    start with their wings retracted.*/
    private boolean isRetracted;

    public ChevroletBird(double startingMileage) {
        super("Chevrolet","Bird",startingMileage, 250);
        this.isRetracted = true;
    }
    
    /** Defaults mileage to 0. */
    public ChevroletBird() {
        super("Chevrolet", "Bird", 0, 250);
    }
    
    /** Returns whether the wings are currently extended. */
    public boolean checkWingsExtended() {
        return this.isRetracted;
    }

    /** Drives just like all other Electric Cars, except make sure that
    you retract your wings first (duh).
    Coding tip: Write this method to re-use the behavior of the
    superclass drive. Don’t copy-and-paste the same code here.*/
    public void drive(double miles) {
        this.isRetracted = true;
        super.drive(miles);
    }

    public boolean canFly(double miles){
        if (miles < 0){
            throw new IllegalArgumentException();
        }
        return !(miles > getMaxRange());
    }

    public void fly(double miles){
        this.isRetracted = false;
        if (miles < 0 || miles > getMaxRange()){
            throw new IllegalArgumentException();
        }
        
    }
}