package com.tecnostore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnostore.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
    
}


