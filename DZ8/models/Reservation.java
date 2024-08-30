package models;

import java.util.Date;

public class Reservation {

    private static int counter = 1000;

    private final int id;

    private Date date;

    private String name;

    private Table table;

    {
        id = ++counter;
    }
    
    public Reservation(Date date, String name, Table table) {
        this.date = date;
        this.name = name;
        this.table = table;
    }

    public int getId() {
        return id;
    }
}
