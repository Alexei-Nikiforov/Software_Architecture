package views;

import java.util.Date;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;

public class BookingView implements View {

    private ViewObserver observer;

    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }
    
    
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования) Брониерование
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя гостя
     */
    public void reservationTable(Date orderDate, int tableNo, String name) {
        if (observer != null) {
            observer.onReservationTable(orderDate, tableNo, name);
        }
    }


    @Override
    public void showReservationTableResultat(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Ваш номер брони №%d.\n", reservationNo);
        } else {
            System.out.println("Ой-ой( что то пошло не так. Попробуйте повторить попытку попозже.");
        }
    }

    /**
     * TODO: Доработать в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменение бронирования)
     * @param oldReservation идентификтор бронирования (старый)
     * @param dateReservation дата бронирования
     * @param tableNo номер столика
     * @param name имя гостя
     */
    public void changesReservationTable(int oldReservation, Date dateReservation, int tableNo, String name) {
        if (observer != null && oldReservation > 0) {
            System.out.println("Столик успешно перебронирован.");
            observer.onReservationTable(dateReservation, tableNo, name);
        } 
        else {
            System.out.println("Ой-ой( что то пошло не так. Попробуйте повторить перебронирование попозже.");
        }
    }

}
