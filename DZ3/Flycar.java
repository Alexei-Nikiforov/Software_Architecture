public class Flycar extends Car {

    public Flycar(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(4);
    }

    public void fly() {
        System.out.println("Автомобиль летит!");
    }

    @Override
    public void movement() {
        fly();
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
