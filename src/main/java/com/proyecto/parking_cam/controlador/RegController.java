package com.proyecto.parking_cam.controlador;

import com.proyecto.parking_cam.modelo.Registro;
import com.proyecto.parking_cam.servicio.registroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class RegController {
    @Autowired
    private registroService ser;

    @GetMapping("/do/listar")
    public ResponseEntity<List<Registro>> getAll() {
        try {
            return new ResponseEntity<>(ser.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/do/search/{id}")
    public ResponseEntity<Registro> getById(@PathVariable("id") Integer id){
        try {
            return  new ResponseEntity<>(ser.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/do/crear")
    public ResponseEntity<Registro> createReproducion(@RequestBody Registro registro){
        try {
            return new ResponseEntity<>(ser.save(registro), HttpStatus.CREATED);
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
/*
    @PutMapping("/do/update/{id}")
    public ResponseEntity<Registro> updateClient(@RequestBody Registro empl, @PathVariable("id") Integer id){
        Registro ca =ser.findById(id);

        if(ca == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                ca.setNombre(empl.getNombre());
                ca.setApellido(empl.getApellido());
                ca.setCorreo(empl.getCorreo());
                ca.setTelefono(empl.getTelefono());
                ca.setContrasena(empl.getContrasena());
                ca.setVeri_contrasena(empl.getVeri_contrasena());
                return new ResponseEntity<>(ser.save(empl), HttpStatus.CREATED);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }*/
}
