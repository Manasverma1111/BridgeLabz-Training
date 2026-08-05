package com.clinic.dao;

import com.clinic.dto.Patient;

import java.util.List;

public interface PatientDAO {
    int insertPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    boolean updatePatient(Patient patient);
    boolean deletePatient(int id); // soft delete (is_active = FALSE)
}
