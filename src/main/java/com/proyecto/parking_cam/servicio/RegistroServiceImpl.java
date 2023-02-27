package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.repositoryo.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl extends GenericServiceImpl<Registro, Integer> implements RegistroService {
    @Autowired
    private RegistroRepository Repository;

    @Override
    public CrudRepository<Registro, Integer> getDao() {
        return Repository;
    }
}
