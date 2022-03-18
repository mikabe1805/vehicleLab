package vehicle;
import java.util.*;

class FordFrivolous extends GasPoweredCar{

    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20); 
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        super("Ford", "Frivolous", 23.6, 20);
    }


}