package DZ5;

import java.util.Collection;

/**
 * Интерфейс БД
 */
interface Database {

    void load();

    void save();

    Collection<Entety> getAll();

}
