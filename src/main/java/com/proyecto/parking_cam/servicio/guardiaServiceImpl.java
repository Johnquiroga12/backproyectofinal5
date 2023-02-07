package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Guardia;
import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.repositoryo.GuardiaRepository;
import com.proyecto.parking_cam.repositoryo.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class guardiaServiceImpl extends GenericServiceImpl<Guardia, Integer> implements guardiaService {
    @Autowired
    private GuardiaRepository Repository;

    @Override
    public CrudRepository<Guardia, Integer> getDao() {
        return Repository;
    }
}
