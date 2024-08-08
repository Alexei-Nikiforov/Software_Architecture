package DZ1.models;

import java.util.List;

public class Scene {
    // Доработать в рамках ДР
    
    private static int counter = 0;

    public int id;

    public List <PoligonalModel> Models;

    public List <Flash> Flashses;

    public List <Camera> Cameras;

    {
        id = ++ counter;
    }

    public List<PoligonalModel> getModels() {
        return Models;
    }

    public List<Flash> getFlashses() {
        return Flashses;
    }

    public List<Camera> getCameras() {
        return Cameras;
    }

    public Scene(List<Flash> flashses) {
        Flashses = flashses;
    }

    public Scene(List<PoligonalModel> models, List<Flash> flashses, List<Camera> cameras) {
        this.Models = models;
        this.Flashses = flashses;
        this.Cameras = cameras;
    }

}
