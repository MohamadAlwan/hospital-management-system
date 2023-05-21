package com.example.hospitalmanagementsystem.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data // used instead of creating the setters and getters for the variables
@NoArgsConstructor // replace the no argument constructor for the class
@AllArgsConstructor // replace the all argument constructor for the class
@Entity // identify the class as an entity so the program knows this class is for creating tables in the database
@Table // allow you to edit the name of the variables before making the table
public class Patent {
    @Id // to identify the primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY) // to make the primary key auto-incremented
    int id;

    @Column
    int phoneNumber;

    @Column(nullable = false)// to specify that this is a column
    String name;

    @Column
    String address;

    @Column
    int age;


    @ManyToMany(mappedBy = "patients",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Doctor> doctors;

    @ManyToMany(mappedBy = "patents",fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Medicine> medicines;
}
