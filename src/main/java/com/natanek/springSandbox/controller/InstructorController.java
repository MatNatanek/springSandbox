package com.natanek.springSandbox.controller;

import com.natanek.springSandbox.exception.ResourceNotFoundException;
import com.natanek.springSandbox.model.Course;
import com.natanek.springSandbox.model.Instructor;
import com.natanek.springSandbox.model.InstructorDetail;
import com.natanek.springSandbox.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/api/instructor")
public class InstructorController {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    Instructor getInstructorById(@PathVariable Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
    }

    //Tu przydaloby sie sprawdzac czy ma jakies dane
    @GetMapping("/{id}/detail")
    InstructorDetail getInstructorDetailById(@PathVariable Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        return instructor.getInstructorDetail();
    }

    @PostMapping
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    //POST czy PUT?
    //Czy musi tu być save //Chyba musi byc bo nie ma transactional -> z Transactional tez nie dziala, dlaczego?
    @PostMapping("/{id}/detail")
    Instructor saveDetailsToInstructor(@PathVariable Long id, @RequestBody InstructorDetail instructorDetail) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructor.setInstructorDetail(instructorDetail);
        instructorRepository.save(instructor);
        return instructor;
    }


    @PutMapping(path = "/{id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor, @PathVariable Long id) {
        Instructor ins = instructorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));

        ins.setFirstName(instructor.getFirstName());
        ins.setLastName(instructor.getLastName());
        ins.setEmail(instructor.getEmail());
        //tu powinno być chyba inst
        return instructorRepository.save(instructor);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteInstructor(@PathVariable Long id, HttpServletResponse response) {
        Instructor instructor = instructorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        response.setStatus(204);
        instructorRepository.delete(instructor);
    }

    //Course OneToMany
    @PostMapping("/{id}/course")
    Instructor addCoursesToInstructor(@PathVariable Long id, @RequestBody Course course) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructor.addCourse(course);
        instructorRepository.save(instructor);
        return instructor;
    }

    //Jaka tu powinna być metoda http?
    @DeleteMapping("/{id}/course")
    Instructor removeCoursesToInstructor(@PathVariable Long id, @RequestBody Course course) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructor.removeCourse(course);
        instructorRepository.save(instructor);
        return instructor;
    }
}
