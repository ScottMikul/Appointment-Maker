package com.AppointmentMaker.appointment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppointmentWrapper {
    @JsonProperty("date")
    String date;
    @JsonProperty("time")
    String time;
    @JsonProperty("desc")
    String desc;
    @JsonProperty("error")
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AppointmentWrapper(String date, String time, String desc) {
        this.date = date;
        this.time = time;
        this.desc = desc;
    }

    public AppointmentWrapper() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
