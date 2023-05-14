package com.example.dentistry.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="appointment", schema = "public")
public class Appointment {

    @Id
    private Integer id;

//    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
////    private List<Doctor> doctor_id = new ArrayList<>();
////
////    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL)
////    private List<Doctor> patient_id = new ArrayList<>();
}
