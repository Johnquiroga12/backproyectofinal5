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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.parking_cam.modelo.Vehiculo;
import com.proyecto.parking_cam.servicio.VehiculoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class vehiculoController {

    @Autowired
    private VehiculoService vehServ;

    @GetMapping("/vehiculo/listar")
    public ResponseEntity<List<Vehiculo>> obtenerLista() {
        try {
            return new ResponseEntity<>(vehServ.listarVehiculosActivos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/vehiculo/list")
    public ResponseEntity<List<Vehiculo>> list() {
        try {
            return new ResponseEntity<>(vehServ.findByAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/vehiculo/search/{id}")
    public ResponseEntity<Vehiculo> search(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(vehServ.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/vehiculo/create")
    public ResponseEntity<Vehiculo> create(@RequestBody Vehiculo vehiculo) {
        try {
            return new ResponseEntity<>(vehServ.save(vehiculo), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/vehiculo/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            vehServ.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vehiculo/update/{id}")
    public ResponseEntity<Vehiculo> update(@RequestBody Vehiculo vehRb, @PathVariable("id") Integer id) {
        Vehiculo veh = vehServ.findById(id);

        if (veh == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                veh.setEstado(vehRb.getEstado());

                return new ResponseEntity<>(vehServ.save(vehRb), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    @GetMapping("/vehiculo/placa/{placa}")
    public ResponseEntity<Vehiculo> search1(@PathVariable("placa") String placa) {
        try {
            return new ResponseEntity<>(vehServ.findByPlaca(placa), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    
}
