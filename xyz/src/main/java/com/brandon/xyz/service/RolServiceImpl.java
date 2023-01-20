package com.brandon.xyz.service;

import com.brandon.xyz.model.Rol;
import com.brandon.xyz.repository.RolRepository;
import com.brandon.xyz.service.interfaces.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;
    @Override
    public void crearRol(Rol rol) {
        rolRepository.save(rol);
    }
    @Override
    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }
    @Override
    public void editarRol(Rol rol) {
        rolRepository.save(rol);
    }
    @Override
    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}
