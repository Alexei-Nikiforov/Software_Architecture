package DZ1.inMemory;

public interface iModelChager {
    
    // Произошло изменение в хранилище моделей

    void NotifyChange();

    void RegisterModelChanger(ModelChangedObserver o);

    void RemoveModelChanger(ModelChangedObserver o);
}
