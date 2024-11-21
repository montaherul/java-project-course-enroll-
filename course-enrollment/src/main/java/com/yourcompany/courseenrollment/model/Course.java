package com.yourcompany.courseenrollment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String instructorName;
    private double price;
    private String duration;
    private String prerequisites;
    private String imageUrl;

    // Getters and Setters
   
    // Additional methods for course enrollment and payment 
    // ...
    // Add any additional fields or methods needed for the Course entity
    // ...
    // Implement any required validations or business logic
    // ...
    // Add any necessary constructors
    // ...

}
