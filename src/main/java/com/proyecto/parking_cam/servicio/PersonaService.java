package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import java.util.List;
import java.util.Map;

public interface PersonaService extends GenericService<Persona, Integer>{

    public Persona findByCedulaAndEstado(String cedula, String estado);

    List<Persona> findAllByEstado();
    
    public Map<String, Object> getAllByNumeros();
}
