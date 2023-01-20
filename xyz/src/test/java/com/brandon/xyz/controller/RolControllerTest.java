package com.brandon.xyz.controller;

import com.brandon.xyz.model.Rol;
import com.brandon.xyz.service.RolServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Before;
import java.util.Arrays;
@RunWith(MockitoJUnitRunner.class)
public class RolControllerTest {

    @Mock
    private RolServiceImpl rolService;

    @InjectMocks
    private RolController rolController;

    private Rol rol;
    private List<Rol> roles;

    @Before
    public void setUp() {
        rol = new Rol();
        rol.setId(1L);
        rol.setNombre("admin");

        roles = Arrays.asList(rol);
    }

    @Test
    public void testCrearRol() {
        rolController.crearRol(rol);
        verify(rolService, times(1)).crearRol(rol);
    }

    @Test
    public void testListarRoles() {
        when(rolService.listarRoles()).thenReturn(roles);
        List<Rol> result = rolController.listarRoles();
        assertEquals(result, roles);
    }

    @Test
    public void testEditarRol() {
        rolController.editarRol(rol);
        verify(rolService, times(1)).editarRol(rol);
    }

    @Test
    public void testEliminarRol() {
        rolController.eliminarRol(1L);
        verify(rolService, times(1)).eliminarRol(1L);
    }
}

