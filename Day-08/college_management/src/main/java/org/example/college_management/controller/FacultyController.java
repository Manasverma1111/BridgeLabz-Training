package org.example.college_management.controller;

import org.example.college_management.entity.Faculty;
import org.example.college_management.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    private final FacultyService facultyService;


    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    // READ all faculty
    @GetMapping
    public List<Faculty> getAllFaculty() {

        return facultyService.getAllFaculty();

    }

    // READ faculty by ID
    @GetMapping("/{id}")
    public Faculty getFacultyById(
            @PathVariable Integer id) {

        return facultyService.getFacultyById(id);

    }

    // CREATE faculty
    @PostMapping
    public Faculty createFaculty(
            @RequestBody Faculty faculty) {

        return facultyService.createFaculty(faculty);

    }

    // UPDATE faculty
    @PutMapping("/{id}")
    public Faculty updateFaculty(
            @PathVariable Integer id,
            @RequestBody Faculty faculty) {

        return facultyService.updateFaculty(id, faculty);

    }

    // DELETE faculty
    @DeleteMapping("/{id}")
    public String deleteFaculty(
            @PathVariable Integer id) {

        facultyService.deleteFaculty(id);

        return "Faculty deleted successfully";

    }

    // Highest salary in each department
    @GetMapping("/highest-paid-by-department")
    public List<Faculty> getHighestPaidByDepartment() {

        return facultyService.getHighestPaidByDepartment();

    }

    // Salary greater than department average
    @GetMapping("/above-department-average")
    public List<Faculty> getAboveDepartmentAverage() {

        return facultyService.getAboveDepartmentAverage();

    }

}