package com.brandon.xyz.service;

import com.brandon.xyz.model.Usuario;
import com.brandon.xyz.repository.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EntityManager entityManager;

    public List<Usuario> obtenerUsuariosPorNombre(String nombre) {
        String consulta = "SELECT u FROM Usuario u WHERE u.nombre = :nombre";
        Query query = entityManager.createQuery(consulta);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    public List<Usuario> obtenerUsuariosPorRol(String rol) {
        String consulta = "SELECT u FROM Usuario u JOIN u.roles r WHERE r.nombre = :rol";
        Query query = entityManager.createQuery(consulta);
        query.setParameter("rol", rol);
        return query.getResultList();
    }

    public void crearUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public void editarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}

