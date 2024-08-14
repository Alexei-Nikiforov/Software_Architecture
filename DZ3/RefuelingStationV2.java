public class RefuelingStationV2 implements Refueling {

    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gaseline -> System.out.println("Заправка бензином");
            default -> System.out.println("Не получилось заправить авто");
        }
    }
    
}