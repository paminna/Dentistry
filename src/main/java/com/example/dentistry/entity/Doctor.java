package com.example.dentistry.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctor", schema = "public")
public class Doctor {

    @Id
    private Integer id;

    private String name;

    private String specialisation;

    private Integer age;

    private Double experience;

    private Double rating;
}
