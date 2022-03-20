package tests;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group1_1_HondaAccordian3 extends BCATestScenario{

    @Override
    public int runTest() {
        HondaAccordian a = new HondaAccordian(2018);

        assertEquals(a.getMPG(), 33.2, .1, "MPG should be 33.2 miles per gallon");

        assertEquals(a.getFuelLevel(), 14.5, .1, "Fuel level should be 14.5 gallons");

        a.drive(99.6);
        assertEquals(a.getFuelLevel(), 11.5, .1, "Fuel level should decrease to 11.5 gallons after driving 99.6 miles");

        assertThrows(IllegalArgumentException.class, () -> {a.drive(-1);}, "Driving mileage cannot be negative.");

        assertEquals(a.getFuelLevel(), 11.5, .1, "Fuel level should be at 11.5 gallons"); //might be a bit repetitive

        a.refillTank();
        assertEquals(a.getFuelLevel(), 14.5, .1, "Fuel level should refill to be 14.5 gallons");

        assertEquals(a.getFuelCapacity(), 14.5, .1, "Fuel capacity should be 14.5 gallons");

        a.drive(448.2);
        assertEquals(a.getFuelLevel(), 1.0, .1, "Fuel level should be at 1 gallon after driving 448.2 miles");

        assertEquals(a.getRemainingRange(), 1.0, .1, "Remaining range should be 1 mile");

        return getFailedCount();
    }
}
