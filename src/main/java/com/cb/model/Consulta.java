package com.cb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Consulta {
    

    @Id
    private Long id;

    @ManyToOne
    private Servicio servicio;

    @ManyToOne
    private User user;

    @OneToOne
    private Sesion sesion;
}
