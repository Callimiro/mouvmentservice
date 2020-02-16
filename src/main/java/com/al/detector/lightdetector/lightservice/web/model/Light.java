package com.al.detector.lightdetector.lightservice.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Light {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean state;
    private Date updatetime;

    public Light() {
    }

    public Light(boolean state, Date updatetime) {
        this.setState(state);
        this.setUpdatetime(updatetime);
    }

    public Light(int id, boolean state, Date updatetime) {
        this.setId(id);
        this.setState(state);
        this.setUpdatetime(updatetime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date date) {
        this.updatetime = date;
    }

}
