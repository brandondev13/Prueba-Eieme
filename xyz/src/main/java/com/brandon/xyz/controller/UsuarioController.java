package com.brandon.xyz.controller;

import com.brandon.xyz.model.Usuario;
import com.brandon.xyz.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuario", description = "La API de Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Operation(summary = "Obtener usuarios por nombre", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @GetMapping("/nombre/{nombre}")
    public List<Usuario> obtenerUsuariosPorNombre(@PathVariable String nombre) {
        return usuarioService.obtenerUsuariosPorNombre(nombre);
    }

    @Operation(summary = "Obtener usuarios por rol", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @GetMapping("/rol/{rol}")
    public List<Usuario> obtenerUsuariosPorRol(@PathVariable String rol) {
        return usuarioService.obtenerUsuariosPorRol(rol);
    }


    @Operation(summary = "Crear un nuevo usuario", description = "Esto solo puede ser hecho por un usuario logueado.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "400", description = "Usuario inválido"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @PostMapping
    public void crearUsuario(@RequestBody @Schema(required = true, description = "El objeto usuario que necesita ser agregado al sistema.") Usuario usuario) {
        usuarioService.crearUsuario(usuario);
    }

    @Operation(summary = "Listar todos los usuarios", description = "Esto solo puede ser hecho por un usuario logueado.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @Operation(summary = "Actualizar un usuario existente", description = "Esto solo puede ser hecho por un usuario logueado.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "400", description = "Usuario inválido"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @PutMapping
    public void editarUsuario(@RequestBody @Schema(required = true, description = "El objeto usuario que necesita ser actualizado en el sistema.") Usuario usuario) {
        usuarioService.editarUsuario(usuario);
    }

    @Operation(summary = "Eliminar un usuario existente", description = "Esto solo puede ser hecho por un usuario logueado.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Usuario no encontrado")})
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable @Schema(required = true, description = "ID del usuario que necesita ser eliminado.") Long id) {
        usuarioService.eliminarUsuario(id);
    }
}








