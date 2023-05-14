package com.example.dentistry.controller;

import com.example.dentistry.dto.Data;
import com.example.dentistry.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping
public class AppointmentController {


    @Autowired
    private AppointmentService appointmentService;

//    @PostMapping("/save")
//    public boolean saveAppointment(@RequestBody Data data) throws ParseException {
//        return appointmentService.saveAppointment(data);
//    }

    @GetMapping("/save/{name}/{email}/{type}/{date}/{time}/{doctor}")
    public boolean saveAppointment(@PathVariable String name, @PathVariable String email, @PathVariable String type, @PathVariable String date, @PathVariable String time, @PathVariable String doctor) throws ParseException {
        Data data = new Data(name, email, type, date, time, doctor);
        return appointmentService.saveAppointment(data);
    }
}
