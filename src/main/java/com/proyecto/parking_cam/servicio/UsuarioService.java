package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Usuario;

public interface UsuarioService extends GenericService<Usuario, Integer>{
    Usuario login (String username, String password);
    boolean porUsername(String username);


}
