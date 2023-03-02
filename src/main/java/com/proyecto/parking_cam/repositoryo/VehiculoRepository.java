package com.proyecto.parking_cam.repositoryo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Vehiculo;

@Repository
public interface VehiculoRepository  extends JpaRepository<Vehiculo, Integer>{
	
	
	public Vehiculo findByPlaca(String placa);
	
}
