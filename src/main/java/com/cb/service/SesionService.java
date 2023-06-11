package com.cb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.model.Dia;
import com.cb.model.Sesion;
import com.cb.repository.SesionRepository;

@Service
public class SesionService {
    
    @Autowired
    private SesionRepository sesionRepository;


    public List<String> disponibles(String date){
      
        List<Sesion> sesions = sesionRepository.findAll();
        List<String> disponibles = new ArrayList<>();

        sesions.forEach(a->{if(a.getDia().getDate().toString().equals(date)){
            disponibles.add(a.hora);
        }});
    
        return disponibles;
    }

    public void defaulSessions(Dia dia){ //Por cada dia creado se agregan estas horas por defecto.
        List<String> sessions = Arrays.asList("9:00-10:00",
        "10:00-11:00","11:00-12:00","12:00-13:00");
        
        for (String string : sessions) {
            sesionRepository.save(new Sesion(string,dia));
        }
        
    }

    public Sesion getSesion(String d){
       
        Sesion sesion = sesionRepository.findAll().stream().filter(a-> a.getDia().getDate().toString().equals(d)).findFirst().orElse(null);
        return sesion;
    }

}
