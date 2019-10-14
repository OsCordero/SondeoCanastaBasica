package com.too.ues.edu.canastabasica.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.too.ues.edu.canastabasica.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

}
