package com.clinic.dao;

import com.clinic.dto.Doctor;

import java.util.List;

public interface DoctorDAO {
    int insertDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(int id); // soft delete (is_active = FALSE)
}
