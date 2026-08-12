package org.example.college_management.controller;

import org.example.college_management.entity.Student;
import org.example.college_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // READ all students
    @GetMapping
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();

    }

    // READ student by ID
    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Integer id) {

        return studentService.getStudentById(id);

    }

    // CREATE student
    @PostMapping
    public Student createStudent(
            @RequestBody Student student) {

        return studentService.createStudent(student);

    }

    // UPDATE student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Integer id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);

    }

    // DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Integer id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";

    }

}