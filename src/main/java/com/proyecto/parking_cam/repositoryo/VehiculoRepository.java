package com.proyecto.parking_cam.repositoryo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Vehiculo;

import java.util.List;

@Repository
public interface VehiculoRepository  extends JpaRepository<Vehiculo, Integer>{

    Vehiculo findByPlaca(String placa);

    List<Vehiculo> findAllByEstado(String a);

}
