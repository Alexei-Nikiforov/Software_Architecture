import java.util.ArrayList;
import java.util.Collection;

public class NotesDBContext extends DbContext implements NotesDatabaseContext {

    @Override
    public Collection<Note> getAll() {
        Collection<Note> noteList = new ArrayList<>();
        // TODO: Этого хостинга быть не должно, тут должен работать внутренний механизм фреймворка
        for(NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()) {
            noteList.add(new Note(
                record.getId(), 
                record.getUserId(), 
                record.getTitle(), 
                record.getDetails(), 
                record.getCreationDate()
                ));
        }
        return noteList;
    }
    
    public NotesDBContext(Database database) {
        super(database);
    }

    @Override
    protected void onModulCreating(ModelBuilder builder) {
        builder.applyConfiguratuon(new NoteConfiguration());
    }
    
}
