package com.cb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Consulta {
    

    @Id
    private Long id;

    @ManyToOne
    private Servicio servicio;

    @ManyToOne
    private User user;
}
