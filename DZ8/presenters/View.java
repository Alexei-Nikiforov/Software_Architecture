package presenters;

import java.util.Collection;
import java.util.Date;

import models.Table;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);
    
    /**
     * Отобразить результат брониварония столика
     * @param reservationNo номер брониварония
     */
    void showReservationTableResultat(int reservationNo);

    /**
     * Установить наблюдателя для представления
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Событие клиент нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя гостя
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Событие клиент нажал на кнопку перебронирования столика
     * @param oldReservation старый номер бронирования
     * @param dateReservation новая дата бронирования
     * @param tableNo номер столика
     * @param name имя гостя
     */
    void changesReservationTable(int oldReservation, Date dateReservation, int tableNo, String name);
}
