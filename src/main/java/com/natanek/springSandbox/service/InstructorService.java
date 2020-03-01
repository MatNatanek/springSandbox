package com.natanek.springSandbox.service;

import com.natanek.springSandbox.model.Instructor;
import com.natanek.springSandbox.model.InstructorDetail;

public interface InstructorService {

    Instructor addDetailsToInstructor(Long id, InstructorDetail instructorDetail);
}
