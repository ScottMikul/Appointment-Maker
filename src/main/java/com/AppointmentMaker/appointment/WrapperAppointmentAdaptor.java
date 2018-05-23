package com.AppointmentMaker.appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class WrapperAppointmentAdaptor {
    public static AppointmentWrapper convertToWrapper(Appointment app){

        SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        SimpleDateFormat date = new SimpleDateFormat("MMM dd");
        return new AppointmentWrapper(date.format(app.date), time.format(app.date), app.desc);
    }

    public static Appointment convertToAppointment(AppointmentWrapper wrapper) throws ParseException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyyhh:mmaaa");
        String wrapperString = wrapper.date+wrapper.time;
        System.out.println(wrapperString);
        Date date = simpleDateFormat.parse(wrapperString);
        Appointment appointment = new Appointment();
        appointment.setDate(date);
        appointment.setDesc(wrapper.getDesc());
        return appointment;



    }

}
