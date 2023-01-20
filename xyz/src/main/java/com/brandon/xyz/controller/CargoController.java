package com.brandon.xyz.controller;

import com.brandon.xyz.model.Cargo;
import com.brandon.xyz.service.CargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoServiceImpl cargoService;

    @PostMapping
    public void crearCargo(@RequestBody Cargo cargo) {
        cargoService.crearCargo(cargo);
    }

    @GetMapping
    public List<Cargo> listarCargos() {
        return cargoService.listarCargos();
    }

    @PutMapping
    public void editarCargo(@RequestBody Cargo cargo) {
        cargoService.editarCargo(cargo);
    }

    @DeleteMapping("/{id}")
    public void eliminarCargo(@PathVariable Long id) {
        cargoService.eliminarCargo(id);
    }
}