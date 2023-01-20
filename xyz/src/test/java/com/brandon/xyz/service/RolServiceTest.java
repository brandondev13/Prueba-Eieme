package com.brandon.xyz.service;

import com.brandon.xyz.model.Rol;
import com.brandon.xyz.repository.RolRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class RolServiceTest {
    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolServiceImpl rolService;

    @Test
    public void testCrearRol() {
        Rol rol = new Rol();
        rolService.crearRol(rol);
        verify(rolRepository, times(1)).save(rol);
    }

    @Test
    public void testListarRoles() {
        List<Rol> roles = new ArrayList<>();
        when(rolRepository.findAll()).thenReturn(roles);
        assertEquals(roles, rolService.listarRoles());
    }

    @Test
    public void testEditarRol() {
        Rol rol = new Rol();
        rolService.editarRol(rol);
        verify(rolRepository, times(1)).save(rol);
    }

    @Test
    public void testEliminarRol() {
        Long id = 1L;
        rolService.eliminarRol(id);
        verify(rolRepository, times(1)).deleteById(id);
    }
}

