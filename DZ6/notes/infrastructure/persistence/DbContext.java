public abstract class DbContext {
    
    protected Database database;

    public DbContext(Database database) {
        this.database = database;
    }

    protected abstract void onModulCreating(ModelBuilder builder);

    public boolean saveChanges() {
        // TODO: Сохранение изменений в базе данных. 
        return true;
    }

}

class ModelBuilder {

    public ModelBuilder applyConfiguratuon(ModelConfiguration<Note> configuration) {
        // TODO: Добавление конфигурации маппинга объекта некоторого объекта к структуре таблицы базы данных
        return this;
    };

}
