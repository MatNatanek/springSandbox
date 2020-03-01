package com.natanek.springSandbox.service;

import com.natanek.springSandbox.exception.ResourceNotFoundException;
import com.natanek.springSandbox.model.Instructor;
import com.natanek.springSandbox.model.InstructorDetail;
import com.natanek.springSandbox.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Transactional
    public Instructor addDetailsToInstructor(Long id, InstructorDetail instructorDetail) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));
        instructor.setInstructorDetail(instructorDetail);
        return instructor;
    }


}
