package com.example.dentistry.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentHistoryDto {

    private Integer id;

    private Date date;

    private String type;

    private String time;

    private Integer patientId;
}
