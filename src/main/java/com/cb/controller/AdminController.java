package com.cb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cb.model.Consulta;
import com.cb.model.User;
import com.cb.repository.ConsultaRepository;
import com.cb.repository.UserRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    ConsultaRepository consultaRepository;

    @GetMapping("/")
    public String adminHome(Model model) {

        //Si quieres traer cualquier registro de la bd debe ser por una clase servicio o repositorio.

        //si quieres procesar o filtrar los datos antes de mostralos en las vistas, lo mejor es hacelo en metodos
        //que iran en  alguna clase servicio donde tambien puedes llamar a alguna clase repositorio(las cuales tienen metodos para llamar a los registro de la bd)
        List<Consulta> consultas = consultaRepository.findAll();

        //Con este metodo puedes pasar un dato con un nombre para invocarlo en el html al que apunta el controlador,
        //en este caso panel
        model.addAttribute("consultas", consultas);
        model.addAttribute("saludo", 12345);

        //en el panel.html podras invocar los valores con el nombre de "consultas" y "saludo"

        return "panel"; 
    }

    
    //Si quieres agregar mas vistas cada una tendra que tener un controlador.

    @GetMapping("/prueba")
    public String prueba() {
        return "prueba"; 
    }


}
