package com.cb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cb.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    
}