package com.AppointmentMaker.core;

import com.AppointmentMaker.appointment.Appointment;
import com.AppointmentMaker.appointment.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by scott on 6/19/2017.
 */
@Component
public class DataBuilder implements ApplicationRunner {

    @Autowired
    AppointmentRepository repo;

    public void run(ApplicationArguments args) throws Exception {

        Appointment appointment = new Appointment();
        appointment.setDesc("interview");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse("21/12/2019");
        appointment.setDate(d);

        Appointment appointment2 = new Appointment();
        appointment2.setDesc("dinner");
        Date d2 = sdf.parse("21/12/2019");
        appointment2.setDate(d2);

        Appointment appointment3 = new Appointment();
        appointment3.setDesc("lunch");
        Date d3 = sdf.parse("21/12/2019");
        appointment3.setDate(d3);

        repo.save(appointment);
        repo.save(appointment2);
        repo.save(appointment3);



    }
}