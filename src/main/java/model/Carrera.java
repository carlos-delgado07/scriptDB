package com.topicos.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    private List<PlanDeEstudio> planes;

    public Carrera() {}

    public Carrera(String nombre, String descripcion, String sigla, Facultad facultad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sigla = sigla;
        this.facultad = facultad;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public Facultad getFacultad() { return facultad; }
    public void setFacultad(Facultad facultad) { this.facultad = facultad; }

    public List<PlanDeEstudio> getPlanes() { return planes; }
    public void setPlanes(List<PlanDeEstudio> planes) { this.planes = planes; }
}
