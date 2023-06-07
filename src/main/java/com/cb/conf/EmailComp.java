package com.cb.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration 
public class EmailComp {

    private final JavaMailSender mailSender;

    
    @Autowired
    public EmailComp(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(String destinatario, String asunto, String contenido) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(contenido);
        mailSender.send(mensaje);
    }

}
