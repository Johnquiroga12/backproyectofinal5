package com.proyecto.parking_cam.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    
	@Transactional(readOnly =true )
	public Vehiculo obPlaca(String placa) {
		return Repository.findByPlaca(placa);
	}


	@Override
	public Vehiculo findByPlaca(String placa) {
		// TODO Auto-generated method stub
		 return Repository.findByPlaca(placa);
	}

}
