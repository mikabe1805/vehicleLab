package vehicle;
import java.util.*;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{

    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20); 
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        super("Ford", "Frivolous", 23.6, 20);
    }

    public boolean canFly(double miles){
        return this.canDrive(miles*3);
    }

    public void fly(double miles){
        if (this.canFly(miles)){
            this.decreaseFuelLevel(miles*3);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void driveAutonomously(double miles){
        if (!this.canDrive(miles*2)) {
            drive(this.getRemainingRange()/2);
            this.decreaseFuelLevel(this.getRemainingRange()/2);
        } else {
            drive(miles);
            this.decreaseFuelLevel(miles);
        }
    }


}