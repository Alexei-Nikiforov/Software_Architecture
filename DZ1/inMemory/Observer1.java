package DZ1.inMemory;

public class Observer1 implements ModelChangedObserver {

    @Override
    public void applyUpdateModel() {
        // TODO Auto-generated method stub
        System.err.println("Была добавлена новая полигональная модель - observer$1");
    }
    
}