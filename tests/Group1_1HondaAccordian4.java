package tests;

import java.util.List;

import bcatest.BCATestScenario;

import vehicle.HondaAccordian;
import bcatest.BCATestScenario;

public class Group1_1HondaAccordian4 extends BCATestScenario{

    @Override
    public int runTest() {
        HondaAccordian h = new HondaAccordian(2.0, 2018);

        assertEquals(h.getMake(), "Honda Accordian", "Make should be Honda Accordian");

        assertEquals(h.getModel(), "2018", "Model should be 2018");

        assertEquals(h.getMileage(), 2.0, .1, "Mileage is 2.0");

        h.drive(30);
        assertEquals(h.getMileage(), 32.0, .1, "Mileage should be 32 after driving 30 miles");

        assertEquals(h.toString(), "Honda Accordian 2018 (32.0 mi)", "toString should return Honda Accordian 2018 (32.0 mi)");

        assertEquals(h.getRemainingRange(), 4.4, .1, "Remaining range is 4.4");

        List<Double> list = List.of(20.2, 20.0, 20.0);
        assertEquals(h.roadTrip(list), 48, .1, "# of days in driving will be 48 days.");

        assertEquals(h.toString(), "Honda Accordian 2018 (90.2 mi)", "toString should return Honda Accordian 2018 (90.2 mi");

        List<Double> list2 = List.of(20.2, -20.0, 20.0);
        assertThrows(IllegalArgumentException.class, () -> {h.roadTrip(list2);}, "Mileage cannot be negative.");

        assertEquals(h.getMileage(), 90.2, .1, "Mileage is 90.2 mi");

        return getFailedCount();
    }
    
}
