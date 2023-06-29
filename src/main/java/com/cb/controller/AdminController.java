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

        List<Consulta> consultas = consultaRepository.findAll();
        model.addAttribute("consultas", consultas);
        return "panel"; 
    }

    

    @GetMapping("/prueba")
    public String prueba() {
        return "prueba"; 
    }


}
