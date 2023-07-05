package com.cb.conf;

import org.springframework.stereotype.Component;
import com.cb.model.Servicio;
import com.cb.repository.ServicioRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@Component
public class Config implements CommandLineRunner {
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public void run(String... args) throws Exception {

        servicioRepository.saveAll(Arrays.asList(new Servicio("Tarot", 25000), new Servicio("Cruz de ankh", 30000)));
        
    }

   

}
