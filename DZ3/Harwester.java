public class Harwester extends Car implements Refueling, Wiping {

    private Refueling refueling;

    private Wiping wiping;

    public Harwester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
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
        throw new UnsupportedOperationException("Unimplemented method 'movement'");
    }

    @Override
    public void maintenance() {
        throw new UnsupportedOperationException("Unimplemented method 'maintenance'");
    }

    @Override
    public boolean gearShifting() {
        throw new UnsupportedOperationException("Unimplemented method 'gearShifting'");
    }

    @Override
    public boolean switchHeadlights() {
        throw new UnsupportedOperationException("Unimplemented method 'switchHeadlights'");
    }

    @Override
    public boolean switchWipers() {
        throw new UnsupportedOperationException("Unimplemented method 'switchWipers'");
    }

    
    public void sweeping() {
        // TODO Auto-generated method stub
        System.out.println("Автомобиль метет улицу");
    }
    
}
