package com.topicos.demo.repository;

import com.topicos.demo.model.PlanDeEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanDeEstudioRepository extends JpaRepository<PlanDeEstudio, Long> {
}
