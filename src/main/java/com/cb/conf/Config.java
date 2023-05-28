package com.cb.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.cb.model.Servicio;
import com.cb.repository.ServicioRepository;

import jakarta.annotation.PostConstruct;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Component
public class Config implements CommandLineRunner {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public void run(String... args) throws Exception {

        servicioRepository.saveAll(Arrays.asList(new Servicio("Tarort", 10000), new Servicio("Ankhn", 10000)));
     
    }

   

}
