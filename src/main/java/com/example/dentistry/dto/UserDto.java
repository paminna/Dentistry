package com.example.dentistry.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    public String name;

    public String email;

    public String password;

    public String phone;

    public String address;

    public String gender;

    public Integer age;
}
