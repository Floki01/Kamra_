package com.cb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String registrationForm() {
        return "inicioPrueba";
    }

    @GetMapping("/servicios")
    public String agenda(){
        return "a";
    }

    @GetMapping("/servicios/calendario")
    public ModelAndView fechas(@RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView("calendario");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @PostMapping("/enviar-consulta")
    public ModelAndView confirmar(@RequestParam("hora") String hora,@RequestParam("fecha") String fecha, @RequestParam("id") String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/user/confirmacion");
        System.out.println(id);
        System.out.println(hora);
        System.out.println(fecha);
        return modelAndView;
    }

    @GetMapping("/confirmacion")
    public ModelAndView confirmacion(){
        ModelAndView modelAndView = new ModelAndView("confirmacion");
        return modelAndView;
    }

}
