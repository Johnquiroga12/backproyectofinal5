package com.proyecto.parking_cam.servicio;

<<<<<<< Updated upstream
import com.proyecto.parking_cam.modelo.Registro;
=======
import com.proyecto.parking_cam.modelo.Persona;
>>>>>>> Stashed changes
import com.proyecto.parking_cam.modelo.Vehiculo;

import java.util.List;

public interface VehiculoService extends GenericService<Vehiculo, Integer>{

    Vehiculo findByPlaca(String placa);
    List<Vehiculo> findAllByEstado(String a);


    List<Vehiculo> findAllByEstado();


}
