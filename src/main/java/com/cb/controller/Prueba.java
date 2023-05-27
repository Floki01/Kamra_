package com.cb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cb.service.DiaService;




@RestController
@RequestMapping("/test")
public class Prueba {

    @Autowired
    private DiaService diaService;

    @GetMapping("/add")
    public ResponseEntity<String> agregarDiasDelMes() {
        diaService.agregarDiasDelMes();
        return ResponseEntity.ok("Días agregados correctamente");
    }

    @GetMapping("/disp")
    public ResponseEntity<List<String>> getHorasDisponibles(@RequestParam("fecha") String fecha) {
    // Aquí deberías implementar la lógica para obtener las horas disponibles para la terapeuta en la fecha proporcionada
    List<String> horasDisponibles = new ArrayList<>();// Obtén las horas disponibles de la terapeuta para la fecha especificada
    horasDisponibles.add(fecha);
    return ResponseEntity.ok(horasDisponibles);
}

}
