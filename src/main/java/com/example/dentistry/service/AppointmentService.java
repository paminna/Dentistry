package com.example.dentistry.service;

import com.example.dentistry.dto.Data;
import com.example.dentistry.entity.AppointmentHistory;
import com.example.dentistry.repository.AppointmentHistoryRepository;
import com.example.dentistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentHistoryRepository appointmentHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean saveAppointment(Data appointmentRequest) throws ParseException {
        int patientId = 0;
        if (userRepository.findUserByEmail(appointmentRequest.getEmail()).isPresent()) {
            patientId = userRepository.findUserByEmail(appointmentRequest.getEmail()).get().getId();
        } else{
            return false;
        }
        int lastId = appointmentHistoryRepository.findAll().size();
        LocalDate changedDate = LocalDate.parse(appointmentRequest.getDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String formattedDate = changedDate.format(DateTimeFormatter.ISO_DATE);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(formattedDate);
        AppointmentHistory appointmentHistory = new AppointmentHistory();
        appointmentHistory.setId(lastId + 1);
        appointmentHistory.setDate(date);
        appointmentHistory.setPatientId(patientId);
        appointmentHistory.setTime(appointmentRequest.getTime());
        appointmentHistory.setType(appointmentRequest.getType());
        appointmentHistoryRepository.saveAndFlush(appointmentHistory);
        return true;
    }
}
