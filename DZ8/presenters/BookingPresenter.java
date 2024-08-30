package presenters;

import java.util.Collection;
import java.util.Date;

import models.Reservation;
import models.Table;

public class BookingPresenter implements ViewObserver {
    
    private final Model model;

    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables() {
        return model.loadTables();
    }

    /**
     * Отобразить список столиков(на представлении)
     */
    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    public void updateUIShowTablesResultat(int reservationNo) {
        view.showReservationTableResultat(reservationNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резервирования столика
     * @param orderDate дата резервирования
     * @param tableNo номер столика
     * @param name имя гостя
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowTablesResultat(reservationNo);
        }
        catch (RuntimeException e) {
            updateUIShowTablesResultat(-1);
        }
    }

    @Override
    public void changeReservationTable(int oldReservations, Date dateReservations, int tableNo, String name) {
        for (Table table : model.loadTables()) {
            for (Reservation reservation : table.getReservations()) {
                if(reservation.getId() == oldReservations) {
                    try {
                        int reservationNo = model.reservationTable(dateReservations, tableNo, name);
                        updateUIShowTablesResultat(reservationNo);
                    }
                    catch (RuntimeException e) {
                        updateUIShowTablesResultat(-10);
                    }
                }                
            }
        }
    }

}
