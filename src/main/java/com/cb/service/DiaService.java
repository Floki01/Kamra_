package com.cb.service;

import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cb.model.Dia;

import com.cb.repository.DiaRepository;


@Service
public class DiaService {
    
    @Autowired
    private DiaRepository dayRepository;

    public void agregarDiasDelMes() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONTH) == month) {
            Dia da = new Dia();
            da.setDate(new java.sql.Date(calendar.getTimeInMillis()));
            dayRepository.save(da);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        
    }
}
