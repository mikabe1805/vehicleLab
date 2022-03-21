package tests;

import vehicle.ChevroletBird;
import bcatest.BCATestScenario;

public class Group1_1_ChevroletBird extends BCATestScenario{

    @Override
    public int runTest() {
        assertThrows(IllegalArgumentException.class, () -> {new ChevroletBird(-1);}, "Mileage cannot be negative.");

        ChevroletBird b = new ChevroletBird(0);
        assertEquals(b.getMake(), "Chevrolet");
        assertEquals(b.getModel(), "Bird");
        assertEquals(b.getMileage(), "0")
        assertEquals(b.getMaxRange(), "250")

        ChevroletBird c = new ChevroletBird();
        assertEquals(c.getMake(), "Chevrolet");
        assertEquals(c.getModel(), "Bird");
        assertEquals(c.getMileage(), "0")
        assertEquals(c.getMaxRange(), "250")

        ChevroletBird d = new ChevroletBird(200000);
        assertEquals(d.getMake(), "Chevrolet");
        assertEquals(d.getModel(), "Bird");
        assertEquals(d.getMileage(), "200000");
        assertEquals(d.getMaxRange(), "250")

        ChevroletBird e = new ChevroletBird();
        assertEquals(e.checkWingsExtended(), "false");
        e.fly(0)
        assertEquals(e.checkWingsExtended(), "true");

        ChevroletBird f = new ChevroletBird();
        f.drive(0);
        assertEquals(e.checkWingsExtended(), "false");
        assertEquals(a.getMileage(), "0");

        assertThrows(IllegalArgumentException.class, () -> {f.drive(-1)}, "Driving mileage cannot be negative.");

        ChevroletBird g = new ChevroletBird();
        g.drive(1000000);
        assertEquals(e.checkWingsExtended(), "false");
        assertEquals(a.getMileage(), "1000000");

        return getFailedCount();
    }
}
