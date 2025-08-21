package com.topicos.demo.controller;

import com.topicos.demo.model.Estudiante;
import com.topicos.demo.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante crear(@RequestBody Estudiante estudiante) {
        return service.guardar(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return service.buscarPorId(id)
                .map(e -> {
                    estudiante.setId(id);
                    return ResponseEntity.ok(service.guardar(estudiante));
                })
                .orElse(ResponseEntity.notFound().build());
    }

@DeleteMapping("/{id}")
public ResponseEntity<Object> eliminar(@PathVariable Long id) {
    return service.buscarPorId(id)
            .map(e -> {
                service.eliminar(id);
                return ResponseEntity.noContent().build();
            })
            .orElse(ResponseEntity.notFound().build());
}

}
