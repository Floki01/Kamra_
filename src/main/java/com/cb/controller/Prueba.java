package com.cb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cb.dto.UserDto;
import com.cb.model.Consulta;
import com.cb.repository.ConsultaRepository;
import com.cb.service.DiaService;
import com.cb.service.SesionService;
import com.cb.service.UserService;




@RestController
@RequestMapping("/test")
public class Prueba {

    @Autowired
    private DiaService diaService;

    @Autowired
    private SesionService sesionService;

    @Autowired
    private UserService userService;

    @Autowired
    private ConsultaRepository consultaRepository;


    @GetMapping("/add")
    public ResponseEntity<String> agregarDiasDelMes() {
        diaService.agregarDiasDelMes();
        return ResponseEntity.ok("Días agregados correctamente");
    }

    @GetMapping("/user")
    public ResponseEntity<String> agregarUser() {
        userService.saveUser(new UserDto("Matias Arias", "m.arias@gmail.com", "12345", "111", "123456789"));
        return ResponseEntity.ok("USUARIO CREADO");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> agregarAdmin() {
        userService.saveAdmin(new UserDto("Matias Arias", "m.luengo@gmail.com", "12345", "111", "123456789"));
        return ResponseEntity.ok("ADMINISTRADOR CREADO");
    }

    @GetMapping("/disp")
    public ResponseEntity<List<String>> getHorasDisponibles(@RequestParam("fecha") String fecha) {
    // Aquí deberías implementar la lógica para obtener las horas disponibles para la terapeuta en la fecha proporcionada
    List<String> horasDisponibles = new ArrayList<>();// Obtén las horas disponibles de la terapeuta para la fecha especificada
    horasDisponibles.addAll(sesionService.disponibles(fecha));
    return ResponseEntity.ok(horasDisponibles);
    }

    @GetMapping("/send")
    public ResponseEntity<String> send(){
        return ResponseEntity.ok("Correo enviado");
    }

    
    @GetMapping("/data")
    public List<Integer> getChartData() {
        List<Integer> data = new ArrayList<>();
        Random random = new Random();

        // Generar 5 valores aleatorios
        for (int i = 0; i < 3; i++) {
            data.add(random.nextInt(100));
        }
        System.out.println(data);

        return data;
    }

    @GetMapping("/lista")
    public List<Consulta> userList(@RequestParam("term") String term){
        

        return consultaRepository.findAll();
    }
}



