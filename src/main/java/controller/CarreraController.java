package com.topicos.demo.controller;

import com.topicos.demo.model.Carrera;
import com.topicos.demo.service.CarreraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public List<Carrera> getAll() {
        return carreraService.findAll();
    }

    @GetMapping("/{id}")
    public Carrera getById(@PathVariable Long id) {
        return carreraService.findById(id);
    }

    @PostMapping
    public Carrera create(@RequestBody Carrera carrera) {
        return carreraService.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera update(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera existing = carreraService.findById(id);
        if (existing != null) {
            existing.setNombre(carrera.getNombre());
            existing.setDescripcion(carrera.getDescripcion());
            existing.setSigla(carrera.getSigla());
            existing.setFacultad(carrera.getFacultad());
            return carreraService.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carreraService.delete(id);
    }
}
