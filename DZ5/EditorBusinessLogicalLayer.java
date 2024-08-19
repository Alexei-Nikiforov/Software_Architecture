package DZ5;

import java.util.Collection;
import java.util.Random;

/**
 * Реализация Business Logical Layer
 */
class EditorBusinessLogicalLayer implements BusinessLogicalLayer {

    private DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();  
    }

    @Override
    public void renderModel(Model3D model) {
        proccesseRender(model);
    }


    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            proccesseRender(model);
        }
    }

    private Random random = new Random();

    private void proccesseRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Model3D> removeModel(Model3D model) {   
        for (Model3D models : getAllModels()) {
            if (models == model) {
                getAllModels().remove(models);
                databaseAccess.removeEntity(models);
            }
        }
        return getAllModels();
    }

    @Override
    public Collection<Texture> removeTexture(Texture texture) {
        for (Texture textures : getAllTextures()) {
            if (textures == texture) {
                getAllTextures().remove(textures);
                databaseAccess.removeEntity(textures);
            }
        }
        return getAllTextures();
    }    
}