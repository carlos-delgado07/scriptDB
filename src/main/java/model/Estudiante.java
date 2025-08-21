package com.topicos.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String ci;

    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;

    private String nacionalidad;
}
