package com.example.dentistry.service;

import com.example.dentistry.dto.AppointmentHistoryDto;
import com.example.dentistry.dto.UserDto;
import com.example.dentistry.entity.AppointmentHistory;
import com.example.dentistry.entity.User;
import com.example.dentistry.repository.AppointmentHistoryRepository;
import com.example.dentistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentHistoryRepository appointmentHistoryRepository;

    public List<UserDto> getUsers(){
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDto userDto = fillUserDto(user);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    private UserDto fillUserDto(User user){
        return new UserDto(user.getId(), user.getName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getAddress(), user.getGender(), user.getAge());
    }

    public UserDto getUserById(Integer id){
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.map(this::fillUserDto).orElse(null);
    }

    public User saveUser(String name, String phone, String email, String password){
        if (userRepository.findUserByEmail(email).isPresent()){
            return null;
        }
        int lastId = userRepository.findAll().size();
        User user = new User();
        user.setId(lastId + 1);
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        userRepository.saveAndFlush(user);
        return user;
    }

    public UserDto getUserByEmail(String email){
        if (userRepository.findUserByEmail(email).isPresent()){
            return  fillUserDto(userRepository.findUserByEmail(email).get());
        }
        return null;
    }

    public List<AppointmentHistoryDto> getHistory(Integer id){
        List<AppointmentHistoryDto> history = new ArrayList<>();
        if (appointmentHistoryRepository.getAppointmentHistoryByPatientId(id).size() > 0){
            for (AppointmentHistory app: appointmentHistoryRepository.getAppointmentHistoryByPatientId(id)) {
                history.add(fillAppointmentHistoryDto(app));
            }
        }
        return history;
    }

    private AppointmentHistoryDto fillAppointmentHistoryDto(AppointmentHistory appointmentHistory){
        return new AppointmentHistoryDto(appointmentHistory.getId(), appointmentHistory.getDate(), appointmentHistory.getType(),
                appointmentHistory.getTime(), appointmentHistory.getPatientId());
    }
}
