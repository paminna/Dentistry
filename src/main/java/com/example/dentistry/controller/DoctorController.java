package com.example.dentistry.controller;

import com.example.dentistry.dto.DoctorDto;
import com.example.dentistry.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/doctors")
    public List<DoctorDto> getDoctors(){
        return doctorService.getList();
    }
}
