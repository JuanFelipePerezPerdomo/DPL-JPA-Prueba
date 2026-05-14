package org.example.miappjuan.model;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Table(name = "student")
@Data
public class Stundent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;
}
