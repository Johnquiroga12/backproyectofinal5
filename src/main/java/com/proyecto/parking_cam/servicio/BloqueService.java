package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Persona;

import java.util.List;

public interface BloqueService extends GenericService<Bloque, Integer>{

<<<<<<< Updated upstream
    List<Bloque> findAllByEstado();
=======
    List<Bloque> listarBloquesActivos();

    List<Bloque> findAllByEstado(String a);
>>>>>>> Stashed changes

}
