package DZ5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * Database
 */
class EditorDatabase implements Database {

    private Random random = new Random();
    
    private final ProjectFile projectFile;

    private Collection<Entety> enteties;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }

    @Override
    public void load() {
        // TODO : Загрузка всех сущностей проекта (модели, текстура, итд)
        
    }

    @Override
    public void save() {
        // TODO : Сохранение текущего состояния всех сущностей проекта
        
    }

    public Collection<Entety> getAll() {
        if (enteties == null) {
            enteties = new ArrayList<>();
            int entCount = random.nextInt(5, 11);
            for (int i = 0; i < entCount; i++) {
                generateModelAndTextures();
            }
        }
        return enteties;
    }

    private void generateModelAndTextures() {
        Model3D model3d = new Model3D();
        int txCount = random.nextInt(3);
        for (int i = 0; i < txCount; i++) {
            Texture texture = new Texture();
            model3d.getTextures().add(texture);
            enteties.add(texture);
        }
        enteties.add(model3d);
    }

}
