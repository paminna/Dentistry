package com.example.dentistry.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(schema = "public")
public class User {

    @Id
    private Integer id;

    public String name;

    public String email;

    public String password;

    public String phone;

    public String address;

    public String gender;

    public Integer age;

    @ManyToOne
    @JoinColumn(name = "appointment_history_id")
    private AppointmentHistory appointment;

}
