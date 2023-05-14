package com.example.dentistry.repository;

import com.example.dentistry.entity.AppointmentHistory;
import com.example.dentistry.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistory, Integer> {
    List<AppointmentHistory> getAppointmentHistoryByPatientId(Integer id);
}
