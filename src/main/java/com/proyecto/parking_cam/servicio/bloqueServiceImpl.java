package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.repositoryo.BloqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class bloqueServiceImpl extends GenericServiceImpl<Bloque, Integer> implements bloqueService {
    @Autowired
    private BloqueRepository Repository;
    @Override
    public CrudRepository<Bloque, Integer> getDao() {
        return Repository;
    }
}
