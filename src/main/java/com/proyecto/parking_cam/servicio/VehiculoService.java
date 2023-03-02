package com.proyecto.parking_cam.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.proyecto.parking_cam.modelo.Vehiculo;

public interface VehiculoService extends GenericService<Vehiculo, Integer>{

	public Vehiculo findByPlaca(String placa);
}
