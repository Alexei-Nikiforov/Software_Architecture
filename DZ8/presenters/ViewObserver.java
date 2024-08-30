package presenters;

import java.util.Date;

public interface ViewObserver {
    
    public void onReservationTable(Date orderDate, int tableNo, String name);

    public void changeReservationTable(int oldReservations, Date dateReservations, int tableNo, String name);
}
