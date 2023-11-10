package itis.hackathon.team5.model;

import java.sql.Timestamp;

public class Sensor {
    private int id;
    private int type;
    private boolean work;
    private Timestamp date;

    public Sensor(int id, int type, boolean work, Timestamp date) {
        this.id = id;
        this.type = type;
        this.work = work;
        this.date = date;
    }

    public Sensor(int type, boolean work, Timestamp date) {
        this.type = type;
        this.work = work;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isWork() {
        return work;
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
