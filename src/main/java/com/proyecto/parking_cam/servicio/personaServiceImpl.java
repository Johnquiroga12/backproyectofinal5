package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.repositoryo.PersonaRepository;
import com.proyecto.parking_cam.repositoryo.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class personaServiceImpl extends GenericServiceImpl<Persona, Integer> implements personaService {
    @Autowired
    private PersonaRepository Repository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return Repository;
    }

}
