package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import java.util.List;

public interface PersonaService extends GenericService<Persona, Integer>{
    List<Persona> listarPersonasActivos();
}
