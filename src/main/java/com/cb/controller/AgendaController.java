package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/agenda")
public class AgendaController {
    
    @GetMapping("/servicios")
    public ModelAndView servicios(){
        ModelAndView modelAndView = new ModelAndView("servicios");
        return modelAndView;
    }

    @GetMapping("/servicios/{id}")
    public ModelAndView fechas(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("fechas");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @PostMapping("/enviar-consulta")
    public ModelAndView confirmar(@RequestParam("hora") String fecha){
        ModelAndView modelAndView = new ModelAndView("redirect:/tarot");
        
        System.out.println(fecha);
        return modelAndView;
    }
    

}
