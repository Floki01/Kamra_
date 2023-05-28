package com.cb.service;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cb.model.Dia;
import com.cb.model.Sesion;
import com.cb.repository.DiaRepository;
import com.cb.repository.SesionRepository;


@Service
public class DiaService {
    
    @Autowired
    private DiaRepository diaRepository;

    @Autowired
    private SesionService sesionService;



    public void agregarDiasDelMes() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONTH) == month) {
            Dia dia = new Dia();
            dia.setDate(new java.sql.Date(calendar.getTimeInMillis()));
            diaRepository.save(dia);
            sesionService.defaulSessions(dia);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        } 
    }
}
