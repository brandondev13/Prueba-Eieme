package com.brandon.xyz.controller;

import com.brandon.xyz.model.Rol;
import com.brandon.xyz.service.RolServiceImpl;
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
@RequestMapping("/roles")
@Tag(name = "Rol", description = "La API de Roles")
public class RolController {

    @Autowired
    private RolServiceImpl rolService;

    @Operation(summary = "Crear un nuevo Rol", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "400", description = "Rol inválido"), @ApiResponse(responseCode = "404", description = "Rol no encontrado")})
    @PostMapping
    public void crearRol(@RequestBody @Schema(required = true, description = "El objeto Rol que necesita ser agregado al sistema.") Rol rol) {
        rolService.crearRol(rol);
    }

    @Operation(summary = "Listar todos los roles", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Rol no encontrado")})
    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarRoles();
    }

    @Operation(summary = "Actualizar un rol existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "400", description = "Rol inválido"), @ApiResponse(responseCode = "404", description = "Rol no encontrado")})
    @PutMapping
    public void editarRol(@RequestBody @Schema(required = true, description = "El objeto Rol que necesita ser actualizado en el sistema.") Rol rol) {
        rolService.editarRol(rol);
    }

    @Operation(summary = "Eliminar un rol existente", description = "Esto puede ser hecho por cualquier usuario.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operación exitosa"), @ApiResponse(responseCode = "404", description = "Rol no encontrado")})
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable @Schema(required = true, description = "ID del rol que necesita ser eliminado.") Long id) {
        rolService.eliminarRol(id);
    }
}




