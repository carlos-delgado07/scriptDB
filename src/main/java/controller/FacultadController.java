package com.topicos.demo.controller;

import com.topicos.demo.model.Facultad;
import com.topicos.demo.service.FacultadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facultades")
public class FacultadController {

    private final FacultadService service;

    public FacultadController(FacultadService service) {
        this.service = service;
    }

    @GetMapping
    public List<Facultad> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Facultad crear(@RequestBody Facultad facultad) {
        return service.guardar(facultad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> actualizar(@PathVariable Long id, @RequestBody Facultad facultad) {
        return service.buscarPorId(id)
                .map(f -> {
                    facultad.setId(id);
                    return ResponseEntity.ok(service.guardar(facultad));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(f -> {
                    service.eliminar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
