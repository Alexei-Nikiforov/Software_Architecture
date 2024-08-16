import javax.xml.crypto.Data;

public class Program {

    /*
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик"
     * 
     * 1.Предусловия
     * 2.Постусловия
     * 3.Инвариант
     * 4.Определить абстрактные и конкретные классы
     * 5.Определить интерфейсы
     * 6.Реализовать наследование
     * 7.Выявить компоненты
     * 8.Разработать Диаграмму компонент используя нотацию UML2.0. Общая без деталей.
     */
    public static void main(String[] args) {

        Core core = new Core();
        MobileAPP mobileAPP = new MobileAPP(core.getTicketProvaider(), core.getCustomerProvaider());
        BusStation busStation = new BusStation(core.getTicketProvaider());

        if (mobileAPP.buyTickets("1111222211112222")) {
            System.out.println("Клиент успешно купил билет.");
            mobileAPP.searchTickets(new Data() {});
            mobileAPP.getTickets().add(new Ticket());
           
            if (busStation.checkTicket() == mobileAPP.getTickets().stream().findFirst().get().isEnable()) {
                System.out.println("Клиент успешно прошел в автобус.");
                mobileAPP.getTickets().stream().findFirst().get().setEnable(true);
            } 
            else {
                System.out.println("Клиент не прошел в автобус.");
            }
        }
    }
}
