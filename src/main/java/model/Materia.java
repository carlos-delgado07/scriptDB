package com.topicos.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int horasDeEstudio;
    private String sigla;
    private int nivel;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PlanDeEstudio plan;

    public Materia() {}

    public Materia(String nombre, int horasDeEstudio, String sigla, int nivel, PlanDeEstudio plan) {
        this.nombre = nombre;
        this.horasDeEstudio = horasDeEstudio;
        this.sigla = sigla;
        this.nivel = nivel;
        this.plan = plan;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getHorasDeEstudio() { return horasDeEstudio; }
    public void setHorasDeEstudio(int horasDeEstudio) { this.horasDeEstudio = horasDeEstudio; }

    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public PlanDeEstudio getPlan() { return plan; }
    public void setPlan(PlanDeEstudio plan) { this.plan = plan; }
}
