package org.akkuratnov.arbina.service;

import java.sql.Date;

public class Device {
    private int id;
    private Date date;

    public Device(int id, Date date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
}
