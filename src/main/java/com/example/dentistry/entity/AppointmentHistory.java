package com.example.dentistry.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "appointment_history", schema = "public")
public class AppointmentHistory {

    @Id
    private Integer id;

    private Date date;

    private String type;

    private String time;

    private Integer patientId;

}
