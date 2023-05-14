package com.example.dentistry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DoctorDto {

    private Integer id;

    private String name;

    private String specialisation;

    private Integer age;

    private Double experience;

    private Double rating;
}
