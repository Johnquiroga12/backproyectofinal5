package com.proyecto.parking_cam.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Usuario;
import com.proyecto.parking_cam.modelo.Vehiculo;
import com.proyecto.parking_cam.servicio.bloqueService;
import com.proyecto.parking_cam.servicio.vehiculoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apii")
public class vehiculoController {
	
	@Autowired
    private vehiculoService vehiServ;
	
	@GetMapping("/vehiculo/list")
    public ResponseEntity<List<Vehiculo>> getAll() {
        try {
            return new ResponseEntity<>(vehiServ.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@PostMapping("/vehiculo/create")
    public ResponseEntity<Vehiculo> createReproducion(@RequestBody Vehiculo vehiculo){
        try {
            return new ResponseEntity<>(vehiServ.save(vehiculo), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
	
	@DeleteMapping("/vehiculo/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
        	vehiServ.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el vehiculo");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
