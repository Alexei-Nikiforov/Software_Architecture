public class CustomerProvaider {
    
    private Database database;

    public CustomerProvaider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String login, String password) {
        return new Customer();
    }

}
