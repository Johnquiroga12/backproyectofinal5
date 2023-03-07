package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Usuario;
import java.util.List;

public interface UsuarioService extends GenericService<Usuario, Integer>{

    List<Usuario> listarUsuariosActivos();
    public Usuario search(String filtro,String filter) throws Exception;

    public Usuario findUsuarioByPersona(Persona p);

    public Usuario findByUsernameAndPassword(String ci, String pas);
}
