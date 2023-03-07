package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Registro;
import java.util.List;

public interface RegistroService extends GenericService<Registro, Integer>{
   
    List<Registro> listarRegistroActivos();

    List<Registro> findAllByEstado();
}
