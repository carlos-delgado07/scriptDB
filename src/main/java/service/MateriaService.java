package com.topicos.demo.service;

import com.topicos.demo.model.Materia;
import com.topicos.demo.repository.MateriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public Materia save(Materia materia) {
        return materiaRepository.save(materia);
    }

    public void delete(Long id) {
        materiaRepository.deleteById(id);
    }
}
