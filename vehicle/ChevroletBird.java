package vehicle;

import java.util.*;


public class ChevroletBird extends ElectricCar implements Flying{
    /** Chevrolet Birds have a 250 mile range on a full charge. They
    start with their wings retracted.*/
    private boolean isExtended;

    public ChevroletBird(double startingMileage) {
        super("Chevrolet","Bird",startingMileage, 250);
        this.isExtended = false;
    }
    
    /** Defaults mileage to 0. */
    public ChevroletBird() {
        super("Chevrolet", "Bird", 0, 250);
        this.isExtended = false;
    }
    
    /** Returns whether the wings are currently extended. */
    public boolean checkWingsExtended() {
        return this.isExtended;
    }

    /** Drives just like all other Electric Cars, except make sure that
    you retract your wings first (duh).
    Coding tip: Write this method to re-use the behavior of the
    superclass drive. Don’t copy-and-paste the same code here.*/
    public void drive(double miles) {
        this.isExtended = false;
        super.drive(miles);
    }

    public boolean canFly(double miles){
        return this.canDrive(miles);
    }

    public void fly(double miles){
        this.isExtended = true;
        if (this.canFly(miles)){
            this.decreaseCharge(miles);
        }
    }
}