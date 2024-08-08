package DZ1.inMemory;

import java.util.ArrayList;
import java.util.List;

import DZ1.models.Flash;
import DZ1.models.PoligonalModel;
import DZ1.models.Scene;
import DZ1.models.Camera;

public class ModelStore implements iModelChager {

    private List<ModelChangedObserver> observers = new ArrayList<>();
    
    public List<PoligonalModel> models = new ArrayList<>();

    public List<Flash> flashses = new ArrayList<>();
    
    public List<Scene> scenes = new ArrayList<>();
    
    public List<Camera> cameras = new ArrayList<>();

    // Добавлен пустой конструктор ModelStore, чтобы заработала программа
    public ModelStore() {
    }

    public ModelStore(List<PoligonalModel> models, List<Flash> flashses, List<Scene> scenes, List<Camera> cameras) {
        this.models = models;
        this.flashses = flashses;
        this.scenes = scenes;
        this.cameras = cameras;
    }

    public Scene GetScena(int ID) {
        for (int i = 0; i < scenes.size(); i++) {
            if (scenes.get(i).id == ID) {
                return scenes.get(i);
            }
        }
        return null;
    }

    public void add(PoligonalModel model) {
        models.add(model);
        NotifyChange();
    }

    @Override
    public void NotifyChange() {
        for (ModelChangedObserver observer: observers) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
       observers.remove(o);
    }

}
