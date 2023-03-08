package com.proyecto.parking_cam.servicio;


import com.proyecto.parking_cam.modelo.Vehiculo;

import java.util.List;

public interface VehiculoService extends GenericService<Vehiculo, Integer>{

    Vehiculo findByPlaca(String placa);
    List<Vehiculo> findAllByEstado();


}
