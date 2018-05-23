package com.AppointmentMaker.index;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;

@Controller
public class indexCtr {

    @RequestMapping(value = {"/","/home"}, produces = MediaType.TEXT_HTML_VALUE)
    public String showHomePage() {
        System.out.println("got here.");
        return "/index.html";
    }
}