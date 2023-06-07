package com.cb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consultas")
public class Consulta {
    

    @Id
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Sesion sesion;

    @ManyToOne
    Servicio servicio;

}
