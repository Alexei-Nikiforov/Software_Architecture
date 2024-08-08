package DZ1.models;

import java.util.List;

public class PoligonalModel {

    public List<Poligon> Poligins;
    
    public List<Texture> Textures;

    public List<Poligon> getPoligins() {
        return Poligins;
    }
    
    public List<Texture> getTextures() {
        return Textures;
    }

    public PoligonalModel(List<Poligon> poligins) {
        this.Poligins = poligins;
    }

    public PoligonalModel(List<Poligon> poligins, List<Texture> textures) {
        this.Poligins = poligins;
        this.Textures = textures;
    }

}
