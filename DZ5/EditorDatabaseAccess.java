package DZ5;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Имплементация DataAccessSlayer
 */
class EditorDatabaseAccess implements DatabaseAccess {

    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList<>();
        for (Entety entety : editorDatabase.getAll()) {
            if (entety instanceof Model3D) {
                models.add((Model3D) entety);
            }
        }
        return models;
    }

    @Override
    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList<>();
        for (Entety entety : editorDatabase.getAll()) {
            if (entety instanceof Texture) {
                models.add((Texture) entety);
            }
        }
        return models;
    }

    @Override
    public void addEntity(Entety entety) {
        editorDatabase.getAll().add(entety);
    }

    @Override
    public void removeEntity(Entety entety) {
        editorDatabase.getAll().remove(entety);
    }

}