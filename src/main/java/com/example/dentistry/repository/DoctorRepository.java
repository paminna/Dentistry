package com.example.dentistry.repository;

import com.example.dentistry.entity.AppointmentHistory;
import com.example.dentistry.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
