package com.example.hospitalmanagementsystem.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Medicine {
    @Id // to identify the primary key
    @GeneratedValue( strategy = GenerationType.IDENTITY) // to make the primary key auto-incremented
    int id;

    @Column
    int quantity;


    @Column
    double price;


    @Column(nullable = false)// to specify that this is a column
    String name;

    @Column
    String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "medicine_patient_table",
            joinColumns = {
                    @JoinColumn(name = "medicine_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "patient_id", referencedColumnName = "id")
            }
    )
    @JsonManagedReference
    private Set<Patent> patents;

}
