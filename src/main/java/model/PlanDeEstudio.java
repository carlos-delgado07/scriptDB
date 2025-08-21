package com.topicos.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Plan_de_estudio")
public class PlanDeEstudio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String autor;
    private String tipoPeriodo;
    private String modalidad;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    public PlanDeEstudio() {}

    public PlanDeEstudio(String nombre, String autor, String tipoPeriodo, String modalidad, Carrera carrera) {
        this.nombre = nombre;
        this.autor = autor;
        this.tipoPeriodo = tipoPeriodo;
        this.modalidad = modalidad;
        this.carrera = carrera;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTipoPeriodo() { return tipoPeriodo; }
    public void setTipoPeriodo(String tipoPeriodo) { this.tipoPeriodo = tipoPeriodo; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }

    public Carrera getCarrera() { return carrera; }
    public void setCarrera(Carrera carrera) { this.carrera = carrera; }
}
