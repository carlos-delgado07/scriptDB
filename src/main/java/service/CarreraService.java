package com.topicos.demo.service;

import com.topicos.demo.model.Carrera;
import com.topicos.demo.repository.CarreraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public List<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    public Carrera findById(Long id) {
        return carreraRepository.findById(id).orElse(null);
    }

    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void delete(Long id) {
        carreraRepository.deleteById(id);
    }
}
