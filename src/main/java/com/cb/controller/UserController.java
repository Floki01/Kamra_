package com.cb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cb.model.Consulta;
import com.cb.model.Servicio;
import com.cb.model.User;
import com.cb.repository.ServicioRepository;
import com.cb.repository.UserRepository;
import com.cb.service.ConsultaService;
import com.cb.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    ServicioRepository servicioRepository;

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    ConsultaService consultaService;

    @GetMapping("/")
    public ModelAndView registrationForm(@RequestParam(value = "gmail", required = false) String gmail, @RequestParam(value ="fecha", required=false) String fecha) {
        ModelAndView modelAndView = new ModelAndView("inicioPrueba");
        modelAndView.addObject("fecha",fecha);
        return modelAndView;
    }

    @GetMapping("/servicios")
    public String agenda(){
        return "servicios";
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
        modelAndView.addObject("hora", hora);
        modelAndView.addObject("fecha", fecha);
        modelAndView.addObject("id",id);
        
        return modelAndView;
    }

    @GetMapping("/confirmacion")
    public ModelAndView confirmacion(@RequestParam("hora") String hora, @RequestParam("fecha") String fecha, 
        @RequestParam("id") String id, Authentication authentication){

        Servicio servicio = servicioRepository.getReferenceById(Long.parseLong(id));
        ModelAndView modelAndView = new ModelAndView("confirmacion");
        modelAndView.addObject("hora", hora);
        modelAndView.addObject("fecha", fecha);
        modelAndView.addObject("servicio", servicio);
        modelAndView.addObject("user", userServiceImpl.findUserByEmail(authentication.getName()));


        consultaService.save(Long.parseLong(id),authentication.getName(),fecha);


        return modelAndView;
    }

    @GetMapping("/rediretHome")
    public String rediretHome(@RequestParam("fecha") String fecha){
        return "redirect:/user/?fecha="+fecha;
    }

    @GetMapping("/sesiones")
    public ModelAndView sesiones(Authentication authentication){
        User user = userServiceImpl.findUserByEmail(authentication.getName());
        ModelAndView modelAndView = new ModelAndView("sesionesUsuario");
        modelAndView.addObject("sesiones", consultaService.getSesiones(user));
        System.out.println("Numero"+consultaService.getSesiones(user).size());
        return modelAndView;
    }



}
