package DZ5;

import java.util.Collection;

/**
 * Интерфейс BLL (Business Logical Layer)
 */
interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();

    Collection<Texture> getAllTextures();

    void renderModel(Model3D model);

    void renderAllModels();

    Collection<Model3D> removeModel(Model3D model);

    Collection<Texture> removeTexture(Texture texture);
}