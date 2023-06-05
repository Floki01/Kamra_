package com.cb.service;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cb.model.Dia;
import com.cb.repository.DiaRepository;

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
