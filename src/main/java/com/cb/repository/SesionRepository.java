package com.cb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cb.model.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long>{
    
}
