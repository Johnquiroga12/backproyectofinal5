package com.proyecto.parking_cam.servicio;

import com.proyecto.parking_cam.modelo.Persona;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.repositoryo.PersonaRepository;
import com.proyecto.parking_cam.repositoryo.RegistroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Integer> implements PersonaService {

    @Autowired
    private PersonaRepository Repository;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return Repository;
    }


    @Override
    public Persona findByCedulaAndEstado(String cedula, String estado) {
        return Repository.findByCedulaAndEstado(cedula, estado);
    }

    @Override
    public List<Persona> findAllByEstado() {
        return Repository.findAllByEstado("A");
    }


}

