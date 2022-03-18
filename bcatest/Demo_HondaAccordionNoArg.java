package bcatest;

public class Demo_HondaAccordionNoArg extends BCATestScenario{
    @Override
    public int runTest() {
        HondaAccordion a = new HondaAccordion(2018);

        assertEquals(a.getMileage(), 0, 0.1, "Mileage of new car should be zero");
        
        return getFailedCount();
    }
}
