package com.proyecto.parking_cam.repositoryo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Vehiculo;

import java.util.List;

@Repository
public interface VehiculoRepository  extends JpaRepository<Vehiculo, Integer>{
    @Query(value = "SELECT * FROM vehiculo v WHERE v.estado = 'A'", nativeQuery = true)
    List<Vehiculo> listarVehiculosActivos();
    
    
    Vehiculo findByPlaca(String placa);
}
