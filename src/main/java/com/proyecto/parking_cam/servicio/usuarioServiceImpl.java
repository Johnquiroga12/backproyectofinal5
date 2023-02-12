package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.repositoryo.PersonaRepository;
import com.proyecto.parking_cam.repositoryo.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class usuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {
    @Autowired
    private UsuarioRepository Repository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return Repository;
    }

    @Override
    public Usuario login(String username, String password) {
        return Repository.findByUsernameAndPassword(username, password);
    }
    @Override
    public boolean porUsername(String username) {
        if (Repository.findByUsername(username)!=null) {
            return true;
        }else {
            return false;
        }
    }
}
