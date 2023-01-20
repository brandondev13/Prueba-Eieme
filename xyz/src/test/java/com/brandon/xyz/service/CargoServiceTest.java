package com.brandon.xyz.service;

import com.brandon.xyz.model.Cargo;
import com.brandon.xyz.repository.CargoRepository;
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
public class CargoServiceTest {
    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoServiceImpl cargoService;

    @Test
    public void testCrearCargo() {
        Cargo cargo = new Cargo();
        cargoService.crearCargo(cargo);
        verify(cargoRepository, times(1)).save(cargo);
    }

    @Test
    public void testListarCargos() {
        List<Cargo> cargos = new ArrayList<>();
        when(cargoRepository.findAll()).thenReturn(cargos);
        assertEquals(cargos, cargoService.listarCargos());
    }

    @Test
    public void testEditarCargo() {
        Cargo cargo = new Cargo();
        cargoService.editarCargo(cargo);
        verify(cargoRepository, times(1)).save(cargo);
    }

    @Test
    public void testEliminarCargo() {
        Long id = 1L;
        cargoService.eliminarCargo(id);
        verify(cargoRepository, times(1)).deleteById(id);
    }
}

