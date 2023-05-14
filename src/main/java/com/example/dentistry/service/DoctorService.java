package com.example.dentistry.service;

import com.example.dentistry.dto.DoctorDto;
import com.example.dentistry.entity.Doctor;
import com.example.dentistry.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorDto> getList(){
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        List<Doctor> doctors = doctorRepository.findAll();
        if (doctors.size() > 0) {
            for (Doctor doctor: doctors){
                doctorDtoList.add(fillDoctorDto(doctor));
            }
        }
        return doctorDtoList;
    }

    private DoctorDto fillDoctorDto(Doctor doctor){
        return new DoctorDto(doctor.getId(), doctor.getName(),doctor.getSpecialisation(), doctor.getAge(),
                doctor.getExperience(), doctor.getRating());
    }
}
