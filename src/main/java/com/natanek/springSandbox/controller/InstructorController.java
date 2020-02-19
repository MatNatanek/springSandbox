package com.natanek.springSandbox.controller;

import com.natanek.springSandbox.exception.ResourceNotFoundException;
import com.natanek.springSandbox.model.Instructor;
import com.natanek.springSandbox.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/instructor")
public class InstructorController {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @GetMapping
    public List<Instructor> getInstructors(){
        return  instructorRepository.findAll();
    }

    @GetMapping("/{id}")
    Instructor getInstructorById(@PathVariable Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
    }

    @PostMapping
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorRepository.save(instructor);
    }

    @PutMapping(path ="/{id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor,  @PathVariable Long id){
        Instructor ins = instructorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));

        ins.setFirstName(instructor.getFirstName());
        ins.setLastName(instructor.getLastName());
        ins.setEmail(instructor.getEmail());
        return instructorRepository.save(instructor);
    }

    @DeleteMapping(path ="/{id}")
    public void deleteInstructor(@PathVariable Long id) {
        Instructor instructor = instructorRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructorRepository.delete(instructor);
    }


}
