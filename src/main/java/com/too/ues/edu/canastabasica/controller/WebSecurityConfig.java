package com.too.ues.edu.canastabasica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import com.too.ues.edu.canastabasica.servicio.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
    
    //Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(resources).permitAll()  
            .antMatchers("/","/home","/index","/index.html").permitAll()            
            .antMatchers("/listarusuarios*").access("hasRole('ADMIN')")
            .antMatchers("/registrarusuario*").access("hasRole('ADMIN')")
            .antMatchers("/editarusuario*").access("hasRole('ADMIN')")
            .antMatchers("/addusuario*").access("hasRole('ADMIN')")
            .antMatchers("/updateusuario*").access("hasRole('ADMIN')")
            .antMatchers("/eliminarusuario*").access("hasRole('ADMIN')")
            .antMatchers("/listarperiodos*").permitAll()
            .antMatchers("/registrarperiodo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/addperiodo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/editarperiodo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/updateperiodo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/finalizarperiodo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/registrarregistrosondeo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/addregistrosondeo*").access("hasRole('USER') or hasRole('ADMIN')")            
            .antMatchers("/listarperiodosondeo*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/registrossondeos*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/eliminarregistro*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/editarregistro*").access("hasRole('USER') or hasRole('ADMIN')")
            .antMatchers("/updateregistrosondeo*").access("hasRole('USER') or hasRole('ADMIN')")
                //.anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .logoutUrl("/app-logout")
                .permitAll()
                //.logoutSuccessUrl("/login?logout");
                .logoutSuccessUrl("/index")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accesodenegado");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}