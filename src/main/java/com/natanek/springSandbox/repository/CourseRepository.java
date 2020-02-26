package com.natanek.springSandbox.repository;

import com.natanek.springSandbox.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
