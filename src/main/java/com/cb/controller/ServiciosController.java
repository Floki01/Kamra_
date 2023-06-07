package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class ServiciosController {

    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
    
    @GetMapping("/ankh")
    public String mostrarAnkh(){
        return "ankh";
    }

    @GetMapping("/tarot")
    public String mostrarTaror(){
        return "tarot";
    }


}
