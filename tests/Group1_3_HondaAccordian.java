package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group1_3_HondaAccordian extends BCATestScenario {

    public int runTest() {
        HondaAccordian c1 = new HondaAccordian(2019);

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(481.5);}, "Cannot drive more than 481.4 miles in one drive");

        c1.drive(0);

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(-1.0);}, "Cannot drive negative miles");

        c1.drive(481.4);

        assertThrows(IllegalArgumentException.class, () -> {c1.drive(2);}, "Not enough fuel to continue driving");

        assertFalse(c1.canDrive(10), "Should return false; Not enough fuel in the car");

        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(-1.0);}, "Cannot refill negative gallons");

        assertThrows(IllegalArgumentException.class, () -> {c1.refillTank(14.6);}, "Cannot refill 14.6 gallons or more");

        System.out.println(c1.getFuelLevel());
        c1.refillTank(14.5); // error here
        assertEquals(c1.getFuelLevel(), 14.5, .1, "Should be at max gallons (14.5) right now.");

        assertEquals(c1.getMileage(), 481.4, .1, "Mileage is not the right value (should be 481.4 miles)");

        return getFailedCount();
    }
}