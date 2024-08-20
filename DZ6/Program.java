import java.util.Date;

public class Program {
    public static void main(String[] args) {
        NotesController controller = new NotesController(
            new ConcreteNoteEditor(
                new NotesDBContext(
                    new NotesDatabase()), 
                    new NotesConsolePresenter()));
        controller.routeGetAll();

    // Д/З
    // 1. Добавить добавление заметки и удаление заметки.
    // 2. Нарисовать UML-диаграмму для текущего проекта
        
        // Добавление заметки
        Note noteAdd = new Note(20, 20, "20", "20", new Date());
        controller.routeAddNote(noteAdd);
        
        // Удаление заметки
        // указываем номер заметки для удаления
        int i = 1; 
        //создаем пустую заметку с указанным номером для удаления
        Note noteRemove = new Note(i, i, null, null, null); 
        controller.routeRemoveNote(noteRemove);
    }
}
