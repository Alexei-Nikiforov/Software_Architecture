public abstract class Car {

    // region Constructors
    
    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }

    // endregion

    // region Public Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    // Подметать улицы
    // public abstract void sweeping();

    // Включение противотуманных фар
    public boolean switchFogLights() {
        fogLights = !fogLights;
        return fogLights;
    }

    protected void setWheelsCount (int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // endregion

     // region Private Fields

    // Марка автомобиля
    private String make;

    // Модель автомобиля
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType carType;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType;

    // Тип коробки передач
    private GearboxType rearboxType;

    // Объем двигателя
    private double engineCapasity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    // endregion
    
}
