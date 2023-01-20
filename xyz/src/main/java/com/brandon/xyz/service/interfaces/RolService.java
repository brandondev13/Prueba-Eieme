package com.brandon.xyz.service.interfaces;

import com.brandon.xyz.model.Rol;
import java.util.List;

public interface RolService {
    void crearRol(Rol rol);
    List<Rol> listarRoles();
    void editarRol(Rol rol);
    void eliminarRol(Long id);
}
