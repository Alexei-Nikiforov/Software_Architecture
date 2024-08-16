import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvaider {
    
    private final Database database;

    private final PaymentProvaider paymentProvaider;

    public TicketProvaider(Database database, PaymentProvaider paymentProvaider) {
        this.database = database;
        this.paymentProvaider = paymentProvaider;
    }

    public Collection<Ticket> searchTickets (int clientId, Date date) {
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if(ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    public boolean buyTickets(int clientId, String cardno) throws RuntimeException {

        // Предусловия
        if (clientId < 0) {
            throw new RuntimeException("Некорректный id клиента.");
        }

        if (cardno.length() != 16) {
            throw new RuntimeException("Некорректный номер карточки.");
        }  

        int orderId = database.createTicketOrders(clientId);
        double amount = database.getTicketAmount();

        // Предусловия
        if (orderId < 0) {
            throw new RuntimeException("Некорректный id оплаты.");
        }

        if (cardno.length() != 16) {
            throw new RuntimeException("Некорректный номер карточки.");
        }

        if (amount != database.getTicketAmount()) {
            throw new RuntimeException("Некорректное списание средств.");
        }

        return paymentProvaider.buyTickets(clientId, cardno, amount);

    }

    public boolean checkTicket() {
        boolean flag = false;
        for (Ticket ticket : database.getTickets()) {
            if (ticket.isEnable()) {
                ticket.setEnable(true);
                // Save database ...
                flag = false;
            }
        }
        return flag;
    }
}
