package com.AppointmentMaker.appointment;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Controller
public class AppointmentCtr {

    @Autowired
    AppointmentRepository appointmentRepository;

    @RequestMapping(value= "/getAppointments",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ArrayList<AppointmentWrapper> getAppointments()
    {
        Lists.newArrayList(appointmentRepository.findAll()).stream().map(WrapperAppointmentAdaptor::convertToWrapper).collect(Collectors.toCollection(ArrayList::new)).stream().forEach(System.out::println);
        return Lists.newArrayList(appointmentRepository.findAll()).stream().map(WrapperAppointmentAdaptor::convertToWrapper).collect(Collectors.toCollection(ArrayList::new));
    }

    @RequestMapping(value = "/addAppointment", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ArrayList<AppointmentWrapper> addAppointment(@RequestBody AppointmentWrapper appointmentWrapper) {
        ArrayList<AppointmentWrapper> errors = new ArrayList<>();

        try{
            appointmentRepository.save(WrapperAppointmentAdaptor.convertToAppointment(appointmentWrapper));
        }
        catch(javax.validation.ConstraintViolationException ex){
            appointmentWrapper.setMsg(ex.getConstraintViolations().stream().findFirst().get().getMessage());
            errors.add(appointmentWrapper);
            return errors;
        } catch (ParseException e) {
            appointmentWrapper.setMsg("incorrect format for the date/time!");
            errors.add(appointmentWrapper);
            return errors;
        }
        return getAppointments();
    }

}
