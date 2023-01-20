package com.brandon.xyz.service;

import com.brandon.xyz.model.Cargo;
import com.brandon.xyz.repository.CargoRepository;
import com.brandon.xyz.service.interfaces.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl  implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public void crearCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }
    @Override

    public List<Cargo> listarCargos() {
        return cargoRepository.findAll();
    }
    @Override

    public void editarCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }
    @Override

    public void eliminarCargo(Long id) {
        cargoRepository.deleteById(id);
    }
}