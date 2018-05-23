package com.AppointmentMaker.appointment;

import com.AppointmentMaker.core.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Date;

// date, time, description
@Entity
public class Appointment extends BaseEntity{
    @Future
    Date date;
    @Size(max = 500, min = 1)
    String desc;

    public Appointment() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
