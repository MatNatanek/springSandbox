package com.natanek.springSandbox.repository;

import com.natanek.springSandbox.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
