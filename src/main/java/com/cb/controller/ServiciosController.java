package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiciosController {
    
    @GetMapping("/ankh")
    public String mostrarAnkh(){
        return "ankh";
    }

    @GetMapping("/tarot")
    public String mostrarTaror(){
        return "tarot";
    }

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

}
