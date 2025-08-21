package com.topicos.demo.service;

import com.topicos.demo.model.PlanDeEstudio;
import com.topicos.demo.repository.PlanDeEstudioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanDeEstudioService {

    private final PlanDeEstudioRepository planDeEstudioRepository;

    public PlanDeEstudioService(PlanDeEstudioRepository planDeEstudioRepository) {
        this.planDeEstudioRepository = planDeEstudioRepository;
    }

    public List<PlanDeEstudio> findAll() {
        return planDeEstudioRepository.findAll();
    }

    public PlanDeEstudio findById(Long id) {
        return planDeEstudioRepository.findById(id).orElse(null);
    }

    public PlanDeEstudio save(PlanDeEstudio plan) {
        return planDeEstudioRepository.save(plan);
    }

    public void delete(Long id) {
        planDeEstudioRepository.deleteById(id);
    }
}
