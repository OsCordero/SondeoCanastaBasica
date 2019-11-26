package com.too.ues.edu.canastabasica.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/listarusuarios").setViewName("listarusuarios");
        registry.addViewController("/registrarusuario").setViewName("registrarusuario");
        registry.addViewController("/accesodenegado").setViewName("prohibido");

        //Vistas de periodo de sondeo
        registry.addViewController("/registrarperiodo").setViewName("registrarperiodo");
        
        
        registry.addViewController("/logout").setViewName("login");
    }
}