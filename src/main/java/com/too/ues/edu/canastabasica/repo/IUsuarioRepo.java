package com.too.ues.edu.canastabasica.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.too.ues.edu.canastabasica.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByUsername(String username);
}
