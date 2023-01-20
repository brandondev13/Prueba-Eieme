package com.brandon.xyz.controller;

import com.brandon.xyz.model.Usuario;
import com.brandon.xyz.service.UsuarioServiceImpl;
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
public class UsuarioControllerTest {

    @Mock
    private UsuarioServiceImpl usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    private Usuario usuario;
    private List<Usuario> usuarios;

    @Before
    public void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Brandon Mejia");
        usuario.setCorreo("brandon@example.com");

        usuarios = Arrays.asList(usuario);
    }

    @Test
    public void testCrearUsuario() {
        usuarioController.crearUsuario(usuario);
        verify(usuarioService, times(1)).crearUsuario(usuario);
    }

    @Test
    public void testListarUsuarios() {
        when(usuarioService.listarUsuarios()).thenReturn(usuarios);
        List<Usuario> result = usuarioController.listarUsuarios();
        assertEquals(usuarios, result);
    }

    @Test
    public void testEditarUsuario() {
        usuarioController.editarUsuario(usuario);
        verify(usuarioService, times(1)).editarUsuario(usuario);
    }

    @Test
    public void testEliminarUsuario() {
        usuarioController.eliminarUsuario(1L);
        verify(usuarioService, times(1)).eliminarUsuario(1L);
    }
}





