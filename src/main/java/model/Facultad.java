package com.topicos.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "facultad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "descripción")
    private String descripcion;

    private String sigla;
}
