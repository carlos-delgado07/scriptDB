package com.topicos.demo.service;

import com.topicos.demo.model.Facultad;
import com.topicos.demo.repository.FacultadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadService {

    private final FacultadRepository repository;

    public FacultadService(FacultadRepository repository) {
        this.repository = repository;
    }

    public List<Facultad> listar() {
        return repository.findAll();
    }

    public Optional<Facultad> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Facultad guardar(Facultad facultad) {
        return repository.save(facultad);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
