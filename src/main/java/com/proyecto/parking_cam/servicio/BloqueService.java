package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Bloque;
import java.util.List;

public interface BloqueService extends GenericService<Bloque, Integer>{

    List<Bloque> findAllByEstado();

}
