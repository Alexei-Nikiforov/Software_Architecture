package DZ5;

import java.util.ArrayList;
import java.util.Collection;

/**
 * UI (User Interface)
 */
class Editor3D implements UiLayer {

    private ProjectFile projectFile;

    private BusinessLogicalLayer businessLogicalLayer;

    private DatabaseAccess databaseAccess;

    private Database database;


    private void inicialize() {
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);    
    }

    @Override
    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        inicialize();
    }

    @Override
    public void showProjectSettings() {
        
        //Предусловие
        checkProjectFile();

        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("Filename: %s\n", projectFile.getFileName());
        System.out.printf("Settings1: %s\n", projectFile.getSetting1());
        System.out.printf("Settings2: %s\n", projectFile.getSetting2());
        System.out.printf("Settings3: %s\n", projectFile.getSetting3());
        System.out.println("******************");
    }

    private void checkProjectFile() {
        if (projectFile == null) {
            throw new RuntimeException("Файл проекта не определен.");
        }
    }

    @Override
    public void saveProject() {

        // Предусловие
        checkProjectFile();

        database.save();
        System.out.println("Изменения успешно сохранены.");
    }

    @Override
    public void printAllModels() {

        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        for (int i = 0; i < models.size(); i++) {
            System.out.printf("---%d---\n", i);
            System.out.println(models.get(i));
            for (Texture texture : models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
        
    }

    @Override
    public void printAllTextures() {

        // Предусловие
        checkProjectFile();

        ArrayList<Texture> textures = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        for (int i = 0; i < textures.size(); i++) {
            System.out.printf("---%d---\n", i);
            System.out.println(textures.get(i));
        }

    }

    @Override
    public void renderAll() {

        // Предусловие
        checkProjectFile();

        System.out.println("Подожите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс. \n", endTime);
    }

    @Override
    public void renderModel(int i) {
       
         // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();
        if (i < 0 || i > models.size() - 1) {
            throw new RuntimeException("Номер модели указан некорректно.");
        }
        System.out.println("Подожите ...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция выполнена за %d мс. \n", endTime);
    }

    @Override
    public Collection<Model3D> removeModels(int i) {
        
        // Предусловие
        checkProjectFile();

        ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();

        if (i < 0 || i > models.size() - 1) {
            throw new RuntimeException("Номер модели указан некорректно.");
        }

        for (int j = 0; j < models.size(); j++) {
            if (j == i) {
                businessLogicalLayer.removeModel(models.get(j));
                System.out.println("Модель удалена");
            }
        }
        return businessLogicalLayer.getAllModels();
    }

    @Override
    public Collection<Texture> removeTextures(int i) {
        ArrayList<Texture> texture = (ArrayList<Texture>)businessLogicalLayer.getAllTextures();
        // ArrayList<Model3D> models = (ArrayList<Model3D>)businessLogicalLayer.getAllModels();

        if (i < 0 || i > texture.size() - 1) {
            throw new RuntimeException("Номер текстур указан некорректно.");
        }

        for (int j = 0; j < texture.size(); j++) {
            if (j == i) {
                businessLogicalLayer.removeTexture(texture.get(j));
                System.out.println("Текстура удалена.");
            }
        }

        return businessLogicalLayer.getAllTextures();
    }
}