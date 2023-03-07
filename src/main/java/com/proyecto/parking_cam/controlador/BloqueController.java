package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Bloque;
import com.proyecto.parking_cam.servicio.BloqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BloqueController {
    @Autowired
    private BloqueService bloServ;

    
    @GetMapping("/bloque/listar")
    public ResponseEntity<List<Bloque>> obtenerLista() {
        try {
            return new ResponseEntity<>(bloServ.findAllByEstado(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping("/bloque/list")
    public ResponseEntity<List<Bloque>> list() {
        try {
            return new ResponseEntity<>(bloServ.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bloque/search/{id}")
    public ResponseEntity<Bloque> search(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(bloServ.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/bloque/create")
    public ResponseEntity<Bloque> create(@RequestBody Bloque bloque){
        try {
            return new ResponseEntity<>(bloServ.save(bloque), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/bloque/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
        	bloServ.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al elminar el Registro");
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/bloque/update/{id}")
    public ResponseEntity<Bloque> update(@RequestBody Bloque bloRb, @PathVariable("id") Integer id){
        Bloque blo =bloServ.findById(id);

        if(blo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
            	blo.setEstado(bloRb.getEstado());
                return new ResponseEntity<>(bloServ.save(bloRb), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
