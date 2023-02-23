package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.servicio.bloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apii")
public class bloqueController {
    @Autowired
    private bloqueService bloser;

    @GetMapping("/block/list")
    public ResponseEntity<List<Bloque>> getAll() {
        try {
            return new ResponseEntity<>(bloser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/block/search/{id}")
    public ResponseEntity<Bloque> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(bloser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/block/create")
    public ResponseEntity<Bloque> createReproducion(@RequestBody Bloque bloque){
        try {
            return new ResponseEntity<>(bloser.save(bloque), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/block/delete/{id}")
    public ResponseEntity<?> deletesong(@PathVariable("id") Integer id) {
        try {
            bloser.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar al bloque");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/block/update/{id}")
    public ResponseEntity<Bloque> updateClient(@RequestBody Bloque empl, @PathVariable("id") Integer id){
        Bloque ca =bloser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setPlazas(empl.getPlazas());
                return new ResponseEntity<>(bloser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
