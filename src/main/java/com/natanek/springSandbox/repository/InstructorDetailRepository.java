package com.natanek.springSandbox.repository;

import com.natanek.springSandbox.model.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {
}
