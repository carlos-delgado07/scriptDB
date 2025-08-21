package com.topicos.demo.repository;

import com.topicos.demo.model.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultadRepository extends JpaRepository<Facultad, Long> {
}
