package models;

import java.util.Date;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     */
    @Override
    public Collection<Table> loadTables() {
        
        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate бронирование столика
     * @param tableNo Номре столика
     * @param name Имя гостя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if(table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name, table);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку попозже.");
    }

    /**
     * TODO: Доработать в рамках домашней работы
     * @param oldReservation старый номер бронирования
     * @param dateReservation дата бронирования
     * @param tableNo номер столика
     * @param name имя гостя
     * @return
     */
    public int changeReservationTable(int oldReservation, Date dateReservation, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservations : table.getReservations()) {
                if (reservations.getId() == oldReservation) {
                    table.getReservations().remove(table.getReservations());
                    return reservationTable(dateReservation, tableNo, name);
                }
            }
        }
        throw new RuntimeException("Ошибка перебронирования столика. Повторите попытку попозже.");
    }

}
