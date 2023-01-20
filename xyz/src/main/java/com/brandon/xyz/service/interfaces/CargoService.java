package com.brandon.xyz.service.interfaces;

import com.brandon.xyz.model.Cargo;
import java.util.List;

public interface CargoService {
    void crearCargo(Cargo cargo);
    List<Cargo> listarCargos();
    void editarCargo(Cargo cargo);
    void eliminarCargo(Long id);
}
