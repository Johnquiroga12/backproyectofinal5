package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.modelo.Guardia;
import com.proyecto.parking_cam.servicio.bloqueService;
import com.proyecto.parking_cam.servicio.guardiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class bloqueController {
    @Autowired
    private bloqueService ser;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Bloque>> getAll() {
        try {
            return new ResponseEntity<>(ser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/do/sBearch/{id}")
    public ResponseEntity<Bloque> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(ser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/do/crear")
    public ResponseEntity<Bloque> createReproducion(@RequestBody Bloque bloque){
        try {
            return new ResponseEntity<>(ser.save(bloque), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/do/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            ser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al docente");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/do/update/{id}")
    public ResponseEntity<Bloque> updateClient(@RequestBody Bloque empl, @PathVariable("id") Integer id){
        Bloque ca =ser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setEspacio(empl.getEspacio());
                return new ResponseEntity<>(ser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
