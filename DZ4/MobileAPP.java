import java.util.Collection;
import java.util.Date;

import javax.xml.crypto.Data;

/*
 * Мобильное приложение
 */
public class MobileAPP {
    
    private final Customer customer;
    private final TicketProvaider ticketProvaider;
    private final CustomerProvaider customerProvaider;
    
    public MobileAPP(TicketProvaider ticketProvaider, CustomerProvaider customerProvaider) {
        this.ticketProvaider = ticketProvaider;
        this.customerProvaider = customerProvaider;
        customer = customerProvaider.getCustomer("<login>", "<password>");
    }
    
    public Collection<Ticket> getTickets() {
        return customer.getTickets();
    }

    public void searchTickets(Data date) {
        customer.setTickets(ticketProvaider.searchTickets(customer.getId(), new Date()));
        
    }
    
    public boolean buyTickets(String cardno) throws RuntimeException {

        // Предусловия
        if (cardno.length() != 16) {
            throw new RuntimeException("Некорректный номер карточки.");
        }       

        return ticketProvaider.buyTickets(customer.getId(), cardno);
    }
}
