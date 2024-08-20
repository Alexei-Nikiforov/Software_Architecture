import java.util.Collection;

public interface NotesDatabaseContext {
    
    Collection<Note> getAll();

    boolean saveChanges();

}
