/**
 * Ядро приложения
 */

public class Core {
    
    private final CustomerProvaider customerProvaider;

    private final TicketProvaider ticketProvaider;

    private final PaymentProvaider paymentProvaider;

    private final Database database;

    public Core() {
        database = new Database();
        customerProvaider = new CustomerProvaider(database);
        paymentProvaider = new PaymentProvaider();
        ticketProvaider = new TicketProvaider(database, paymentProvaider);
    }

    public TicketProvaider getTicketProvaider() {
        return ticketProvaider;
    }

    public CustomerProvaider getCustomerProvaider() {
        return customerProvaider;
    }
}