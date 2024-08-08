package DZ1;

import java.util.ArrayList;
import java.util.List;

import DZ1.inMemory.ModelStore;
import DZ1.inMemory.Observer1;
import DZ1.models.Poligon;
import DZ1.models.PoligonalModel;

public class Program {
    
    public static void main(String[] args) {

        Observer1 observer1 = new Observer1();
        
        ModelStore store = new ModelStore();
        store.RegisterModelChanger(observer1);

        Poligon p1 = new Poligon();
        
        List<Poligon> poligins = new ArrayList<>();
        poligins.add(p1);

        PoligonalModel poligonalModel = new PoligonalModel(poligins);

        store.add(poligonalModel);
    }
}