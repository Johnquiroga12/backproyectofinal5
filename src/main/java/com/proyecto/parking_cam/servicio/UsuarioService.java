package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.modelo.Usuario;
import java.util.List;

public interface UsuarioService extends GenericService<Usuario, Integer>{

    public Usuario search(String filtro,String filter) throws Exception;

    public Usuario findUsuarioByPersona(Persona p);
    List<Usuario> findAllByEstado(String a);



    List<Usuario> findAllByEstado();


    public Usuario findByUsernameAndPassword(String ci, String pas);
}
