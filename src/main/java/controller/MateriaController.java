package com.topicos.demo.controller;

import com.topicos.demo.model.Materia;
import com.topicos.demo.service.MateriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping
    public List<Materia> getAll() {
        return materiaService.findAll();
    }

    @GetMapping("/{id}")
    public Materia getById(@PathVariable Long id) {
        return materiaService.findById(id);
    }

    @PostMapping
    public Materia create(@RequestBody Materia materia) {
        return materiaService.save(materia);
    }

    @PutMapping("/{id}")
    public Materia update(@PathVariable Long id, @RequestBody Materia materia) {
        Materia existing = materiaService.findById(id);
        if (existing != null) {
            existing.setNombre(materia.getNombre());
            existing.setHorasDeEstudio(materia.getHorasDeEstudio());
            existing.setSigla(materia.getSigla());
            existing.setNivel(materia.getNivel());
            existing.setPlan(materia.getPlan());
            return materiaService.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        materiaService.delete(id);
    }
}
