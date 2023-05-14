package com.example.dentistry.controller;

import com.example.dentistry.dto.AppointmentHistoryDto;
import com.example.dentistry.dto.AuthDto;
import com.example.dentistry.dto.UserDto;
import com.example.dentistry.entity.AppointmentHistory;
import com.example.dentistry.entity.User;
import com.example.dentistry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{email}/{password}")
    public UserDto login(@PathVariable("email")  String email, @PathVariable("password") String password){
        if (userService.getUserByEmail(email) != null) {
            UserDto userDto = userService.getUserByEmail(email);
            if (userDto.getEmail().equals(email) &&
            userDto.getPassword().equals(password)){
                return userDto;
            }
        }
        return null;
    }

    @GetMapping("/getUserBy/{patientId}")
    public UserDto getUserById(@PathVariable("patientId") Integer patientId) {
        UserDto userDto =  userService.getUserById(patientId);
        return userDto;
    }

    @GetMapping("/appointment/history/by/{id}")
    public List<AppointmentHistoryDto> getHistoryById(@PathVariable("id") Integer id){
        return userService.getHistory(id);
    }

    @GetMapping("registration/{name}/{phone}/{email}/{password}")
    public User registrationUser(@PathVariable String name, @PathVariable String phone, @PathVariable String email, @PathVariable String password){
        return userService.saveUser(name, phone, email, password);
    }
}
