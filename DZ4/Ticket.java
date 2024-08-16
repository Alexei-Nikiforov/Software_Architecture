import java.util.Date;

/**
 * Билет
 */
public class Ticket {
    
    private int id;

    private int customerId;

    private Date date;

    private String qrcode;

    private boolean enable = false;

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
