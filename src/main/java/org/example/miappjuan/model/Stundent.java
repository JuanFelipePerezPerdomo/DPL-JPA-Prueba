package org.example.miappjuan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Stundent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotBlank(message = "El email no puede estar vacio")
    @Email(message = "El email debe tener un formato valido")
    private String email;

    private int age;
}
