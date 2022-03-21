package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving{

    private int modelNum;

    /** modelNum specifies the model number. Tesla cares about that
    stuff. Tesla Model Z’s have a 340 mile range on a full charge.
    For a Tesla, the make is Tesla. The model is Z. The model number is
    an additional value.
    */
    public TeslaModelZ(double startingMileage, int modelNum) {
        super("Tesla", "Z", startingMileage, 340);
        this.modelNum = modelNum;
    }

    /** Defaults mileage to 0. */
    public TeslaModelZ(int modelNum) {
        super("Tesla", "Z", 340);
        this.modelNum = modelNum;
    }

    /** Returns the model number.*/
    public int getModelNum() {
        return this.modelNum;
    }

    /** Returns the model and model number concatenated together. For
    example, returns "Z70" for modelNum 70. */
    @Override
    public String getModel() {
        return "Z" + modelNum;
    }

    /** Prints out the make, model, model number, and mileage.
    Ex: "Tesla Z70 (30.0 mi)"
    You may not need to implement this method depending on how you
    implement Car.toString()
    */
    public String toString() {
        return super.toString();
    }
    
    public void driveAutonomously(double miles){
        if (!this.canDrive(miles)) {
            drive(this.getRemainingRange());
        } else {
            drive(miles);
        }
    }
    
}
