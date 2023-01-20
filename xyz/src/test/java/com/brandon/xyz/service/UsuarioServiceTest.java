package com.brandon.xyz.service;

import com.brandon.xyz.model.Usuario;
import com.brandon.xyz.repository.UsuarioRepository;
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
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    public void testCrearUsuario() {
        Usuario usuario = new Usuario();
        usuarioService.crearUsuario(usuario);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    public void testListarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        when(usuarioRepository.findAll()).thenReturn(usuarios);
        assertEquals(usuarios, usuarioService.listarUsuarios());
    }

    @Test
    public void testEditarUsuario() {
        Usuario usuario = new Usuario();
        usuarioService.editarUsuario(usuario);
        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    public void testEliminarUsuario() {
        Long id = 1L;
        usuarioService.eliminarUsuario(id);
        verify(usuarioRepository, times(1)).deleteById(id);
    }
}

