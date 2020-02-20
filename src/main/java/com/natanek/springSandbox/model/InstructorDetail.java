package com.natanek.springSandbox.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class InstructorDetail implements Serializable {

    private static final long serialVersionUID = 5668361256234984906L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String youtubeChannel;
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail")
    @JsonBackReference
    private Instructor instructor;



}
