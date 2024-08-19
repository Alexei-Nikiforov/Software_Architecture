package DZ5;

import java.util.Collection;

/**
 * Интерфейс Ui (User Interface)
 */
interface UiLayer {

    void openProject(String fileName);

    void showProjectSettings();

    void saveProject();
    
    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int i);

    Collection<Model3D> removeModels(int i);

    Collection<Texture> removeTextures(int i);
}