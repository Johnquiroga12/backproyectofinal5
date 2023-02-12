package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;

public interface personaService extends GenericService<Persona, Integer>{
    public Persona findByCorreoAndContrasenia( String correo , String contra);

}
