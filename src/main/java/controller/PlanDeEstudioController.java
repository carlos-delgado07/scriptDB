package com.topicos.demo.controller;

import com.topicos.demo.model.PlanDeEstudio;
import com.topicos.demo.service.PlanDeEstudioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanDeEstudioController {

    private final PlanDeEstudioService planService;

    public PlanDeEstudioController(PlanDeEstudioService planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<PlanDeEstudio> getAll() {
        return planService.findAll();
    }

    @GetMapping("/{id}")
    public PlanDeEstudio getById(@PathVariable Long id) {
        return planService.findById(id);
    }

    @PostMapping
    public PlanDeEstudio create(@RequestBody PlanDeEstudio plan) {
        return planService.save(plan);
    }

    @PutMapping("/{id}")
    public PlanDeEstudio update(@PathVariable Long id, @RequestBody PlanDeEstudio plan) {
        PlanDeEstudio existing = planService.findById(id);
        if (existing != null) {
            existing.setNombre(plan.getNombre());
            existing.setAutor(plan.getAutor());
            existing.setTipoPeriodo(plan.getTipoPeriodo());
            existing.setModalidad(plan.getModalidad());
            existing.setCarrera(plan.getCarrera());
            return planService.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        planService.delete(id);
    }
}
