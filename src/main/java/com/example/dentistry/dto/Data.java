package com.example.dentistry.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Data {
    private String name;
    private String email;
    private String type;
    private String date;
    private String time;
    private String doctor;
}
