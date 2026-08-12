package org.example.college_management.service;

import org.example.college_management.entity.Faculty;
import org.example.college_management.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;


    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    // Get all faculty
    public List<Faculty> getAllFaculty() {

        return facultyRepository.findAll();

    }

    // Get faculty by ID
    public Faculty getFacultyById(Integer id) {

        return facultyRepository.findById(id).orElse(null);

    }

    // Create faculty
    public Faculty createFaculty(Faculty faculty) {

        return facultyRepository.save(faculty);

    }

    // Update faculty
    public Faculty updateFaculty(Integer id, Faculty faculty) {

        Faculty existingFaculty =
                facultyRepository.findById(id).orElse(null);


        if (existingFaculty == null) {
            return null;
        }

        existingFaculty.setFirstName(faculty.getFirstName());

        existingFaculty.setLastName(faculty.getLastName());

        existingFaculty.setGender(faculty.getGender());

        existingFaculty.setEmail(faculty.getEmail());

        existingFaculty.setAddress(faculty.getAddress());

        existingFaculty.setCity(faculty.getCity());

        existingFaculty.setState(faculty.getState());

        existingFaculty.setDepartment(faculty.getDepartment());

        existingFaculty.setDesignation(faculty.getDesignation());

        existingFaculty.setJoiningYear(faculty.getJoiningYear());

        existingFaculty.setSalary(faculty.getSalary());


        return facultyRepository.save(existingFaculty);

    }

    // Delete faculty
    public void deleteFaculty(Integer id) {

        facultyRepository.deleteById(id);

    }

    // Highest paid faculty in each department
    public List<Faculty> getHighestPaidByDepartment() {

        return facultyRepository
                .findHighestPaidFacultyByDepartment();

    }

    // Faculty above department average salary
    public List<Faculty> getAboveDepartmentAverage() {

        return facultyRepository
                .findFacultyAboveDepartmentAverage();

    }

}