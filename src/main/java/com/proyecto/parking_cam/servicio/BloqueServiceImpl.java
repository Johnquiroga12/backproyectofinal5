package com.proyecto.parking_cam.servicio;
import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.repositoryo.BloqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BloqueServiceImpl extends GenericServiceImpl<Bloque, Integer> implements BloqueService {
    @Autowired
    private BloqueRepository Repository;
    @Override
    public CrudRepository<Bloque, Integer> getDao() {
        return Repository;
    }

    @Override
    public List<Bloque> findAllByEstado() {
        return Repository.findAllByEstado("A");
    }
}


