package com.cb.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.model.Consulta;
import com.cb.model.Dia;
import com.cb.model.Servicio;
import com.cb.model.Sesion;
import com.cb.model.User;
import com.cb.repository.ConsultaRepository;
import com.cb.repository.ServicioRepository;
import com.cb.repository.UserRepository;

@Service
public class ConsultaService {

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SesionService sesionService;

    @Autowired
    ConsultaRepository consultaRepository;

    public void save(Long id, String gmail, String d){
        sesionService.change(d);
        Sesion sesion = sesionService.getSesion(d);
        Servicio servicio = servicioRepository.getReferenceById(id);
        User user = userRepository.findByEmail(gmail);

        Consulta consulta = new Consulta(user, sesion, servicio);
        consultaRepository.save(consulta);
    
    }

    public List<Consulta> getSesiones(User user){
        return consultaRepository.findAll().stream().filter(u -> u.getUser().getId() == user.getId()).collect(Collectors.toList());
    }
    
}
