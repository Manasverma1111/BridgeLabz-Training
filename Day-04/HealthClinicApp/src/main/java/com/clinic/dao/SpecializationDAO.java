package com.clinic.dao;

import com.clinic.dto.Specialization;

import java.util.List;

public interface SpecializationDAO {
    int insertSpecialization(Specialization specialization);
    Specialization getSpecializationById(int id);
    List<Specialization> getAllSpecializations();
    boolean updateSpecialization(Specialization specialization);
    boolean deleteSpecialization(int id);
}
