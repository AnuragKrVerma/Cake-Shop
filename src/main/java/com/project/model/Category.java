package com.project.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String name;


}
