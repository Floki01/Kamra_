package com.cb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cb.model.Dia;



@Repository
public interface DiaRepository extends JpaRepository<Dia,Long> {
    
}
