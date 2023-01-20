package com.brandon.xyz.controller;

import com.brandon.xyz.model.Cargo;
import com.brandon.xyz.service.CargoServiceImpl;
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
public class CargoControllerTest {

    @Mock
    private CargoServiceImpl cargoService;

    @InjectMocks
    private CargoController cargoController;

    private Cargo cargo;
    private List<Cargo> cargos;

    @Before
    public void setUp() {
        cargo = new Cargo();
        cargo.setId(1L);
        cargo.setNombre("Jefe de Proyecto");

        cargos = Arrays.asList(cargo);
    }

    @Test
    public void testCrearCargo() {
        cargoController.crearCargo(cargo);
        verify(cargoService, times(1)).crearCargo(cargo);
    }

    @Test
    public void testListarCargos() {
        when(cargoService.listarCargos()).thenReturn(cargos);
        List<Cargo> result = cargoController.listarCargos();
        assertEquals(result, cargos);

    }


    @Test
    public void testEditarCargo() {
        cargoController.editarCargo(cargo);
        verify(cargoService, times(1)).editarCargo(cargo);
    }

    @Test
    public void testEliminarCargo() {
        cargoController.eliminarCargo(1L);
        verify(cargoService, times(1)).eliminarCargo(1L);
    }
}




