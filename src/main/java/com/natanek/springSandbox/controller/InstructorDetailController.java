package com.natanek.springSandbox.controller;

import com.natanek.springSandbox.exception.ResourceNotFoundException;
import com.natanek.springSandbox.model.InstructorDetail;
import com.natanek.springSandbox.repository.InstructorDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController()
@RequestMapping(path = "/api/instructor/detail")
public class InstructorDetailController {

    InstructorDetailRepository instructorDetailRepository;

    @Autowired
    public InstructorDetailController(InstructorDetailRepository instructorDetailRepository) {
        this.instructorDetailRepository = instructorDetailRepository;
    }

    //ta metoda dziala ale z punktu logicznego jest raczej bez sensu
    @GetMapping()
    public List<InstructorDetail> getInstructorsDetails(){
        return  instructorDetailRepository.findAll();
    }

    @GetMapping("/{id}")
    InstructorDetail getDetailById(@PathVariable Long id) {
        return instructorDetailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor Detail", "id", id));
    }



}
