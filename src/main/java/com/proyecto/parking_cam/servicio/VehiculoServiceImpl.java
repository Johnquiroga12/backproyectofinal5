package com.proyecto.parking_cam.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Vehiculo;
import com.proyecto.parking_cam.repositoryo.BloqueRepository;
import com.proyecto.parking_cam.repositoryo.VehiculoRepository;

@Service
public class VehiculoServiceImpl extends GenericServiceImpl<Vehiculo, Integer> implements VehiculoService{
	@Autowired
    private VehiculoRepository Repository;
    @Override
    public CrudRepository<Vehiculo, Integer> getDao() {
        return Repository;
    }
}