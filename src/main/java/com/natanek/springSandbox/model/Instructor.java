package com.natanek.springSandbox.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
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
}
