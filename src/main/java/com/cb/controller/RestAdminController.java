package com.cb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.Consulta;
import com.cb.repository.ConsultaRepository;

@RestController
@RequestMapping("/rest")
public class RestAdminController {

    @Autowired
    ConsultaRepository consultaRepository;

    
    
}
