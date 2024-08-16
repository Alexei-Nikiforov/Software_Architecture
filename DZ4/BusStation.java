/**
 * Автобусная станция
 */
public class BusStation {

    private final TicketProvaider ticketProvaider;

    public BusStation(TicketProvaider ticketProvaider) {
        this.ticketProvaider = ticketProvaider;
    }

    public boolean checkTicket() {
        return ticketProvaider.checkTicket();
    }
    
}
