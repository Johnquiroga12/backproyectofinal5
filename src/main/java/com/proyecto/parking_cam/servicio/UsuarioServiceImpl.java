package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.repositoryo.PersonaRepository;
import com.proyecto.parking_cam.repositoryo.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuariosActivos() {
        return usuarioRepository.listarUsuariosActivos();
    }
     @Override
    public Usuario search(String filtro,String filter) throws Exception {
        return usuarioRepository.search(filtro, filter);  
    }

}
