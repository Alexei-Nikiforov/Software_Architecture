public class SportCar extends Car implements Refueling, Wiping {

    private Refueling refueling;

    private Wiping wiping;

    public SportCar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(3);
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    public void setWipingStation(Wiping wipingStation) {
        this.wiping = wipingStation;
    }

    // Заправить автомобиль
    @Override
    public void fuel(FuelType fuelType) {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    // Протирка зеркал
    @Override
    public void wipMirrors() {
        if (wiping != null) {
           wiping.wipMirrors();
        }
    }

    // Протирка лобового стекла
    @Override
    public void wipWindshield() {
        if (wiping != null) {
           wiping.wipWindshield();
        }
    }

    // Протирка фар
    @Override
    public void wipHeadlights() {
        if (wiping != null) {
           wiping.wipHeadlights();
        }
    }

    @Override
    public void movement() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movement'");
    }

    @Override
    public void maintenance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'maintenance'");
    }

    @Override
    public boolean gearShifting() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gearShifting'");
    }

    @Override
    public boolean switchHeadlights() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchHeadlights'");
    }

    @Override
    public boolean switchWipers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchWipers'");
    }

    
}
