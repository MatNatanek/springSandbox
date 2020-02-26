package com.natanek.springSandbox.controller;

import com.natanek.springSandbox.exception.ResourceNotFoundException;
import com.natanek.springSandbox.model.Course;
import com.natanek.springSandbox.model.Student;
import com.natanek.springSandbox.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/student")
public class StudentController {

    StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    Student getInstructorById(@PathVariable Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping(path = "/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id) {
        Student std = studentRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        std.setFirstName(student.getFirstName());
        std.setLastName(student.getLastName());
        std.setEmail(student.getEmail());
        return studentRepository.save(std);
    }

}
