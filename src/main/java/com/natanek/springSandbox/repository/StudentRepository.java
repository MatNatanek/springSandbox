package com.natanek.springSandbox.repository;

import com.natanek.springSandbox.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
