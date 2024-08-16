import java.util.ArrayList;
import java.util.Collection;

/*
 * База данных
 */
public class Database {
    
    private static int counter;

    private Collection<Ticket> tickets = new ArrayList<>();

    private Collection<Customer> customers = new ArrayList<>();

    public Database() {
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     * @return
     */
    public int createTicketOrders (int clientId) throws RuntimeException {

        // Предусловия
        if (clientId < 0) {
            throw new RuntimeException("Некорректный id клиента.");
        }

        return ++counter;
    }
}
