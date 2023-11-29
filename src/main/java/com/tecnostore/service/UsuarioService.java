package com.tecnostore.service;

import com.tecnostore.model.Usuario;

public interface UsuarioService {
    Usuario buscarPorEmail(String email);
    void guardarUsuario(Usuario usuario);
}
