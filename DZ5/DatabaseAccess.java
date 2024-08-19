package DZ5;

import java.util.Collection;

/**
 * Интерфейс DAL (Data Access Layer)
 */
interface DatabaseAccess {

    void addEntity(Entety entety);

    void removeEntity(Entety entety);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();

}
