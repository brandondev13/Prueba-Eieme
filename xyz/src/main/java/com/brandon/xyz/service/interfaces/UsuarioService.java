package com.brandon.xyz.service.interfaces;

import com.brandon.xyz.model.Usuario;
import java.util.List;

public interface UsuarioService {
    void crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    void editarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);

}
