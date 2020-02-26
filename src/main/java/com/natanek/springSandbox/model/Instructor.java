package com.natanek.springSandbox.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Table(name="instructor", schema ="public" )
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1278568611368743362L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JoinColumn(name="instructor_detail_id", referencedColumnName = "id")
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy ="instructor", cascade = {CascadeType.ALL})
    private Set<Course> courses;

    public void addCourse(Course course){
        courses.add(course);
        course.setInstructor(this);
    }

    public void removeCourse(Course course){
        courses.remove(course);
        course.setInstructor(null);
    }

}
