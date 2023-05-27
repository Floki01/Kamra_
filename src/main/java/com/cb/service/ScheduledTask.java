package com.cb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTask {
    
    @Autowired
    private DiaService dayService;

    // @Scheduled(cron = "0 0 0 1 * ?") // Ejecutar a medianoche del primer día de cada mes
    // public void agregarDiasDelMes() {
    //     dayService.agregarDiasDelMes();
    // }

}
